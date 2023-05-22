package com.heiwalocal.fullstackapplicantandroidapp.screens.resumedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.heiwalocal.domain.entities.Resume
import com.heiwalocal.domain.entities.VacancyInfo
import com.heiwalocal.domain.usecases.DeleteResumeUseCase
import com.heiwalocal.domain.usecases.GetResumeUseCase
import com.heiwalocal.fullstackapplicantandroidapp.base.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ResumeDetailViewModel(
    private val getResumeUseCase: GetResumeUseCase,
    private val deleteResumeUseCase: DeleteResumeUseCase,
): BaseViewModel() {
    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _, throwable ->
        throwable.printStackTrace()
    }

    private val _resume = MutableLiveData<Resume?>()
    val resume: LiveData<Resume?>
        get() { return _resume }

    fun getResume(
        resumeId: String
    ) {
        launch(Dispatchers.IO + coroutineExceptionHandler) {
            _resume.postValue(
                getResumeUseCase.invoke(
                    resumeId=resumeId
                )
            )
        }
    }

    suspend fun deleteResume(
        resumeId: String
    ) {
        withContext(Dispatchers.IO + coroutineExceptionHandler) {
            return@withContext deleteResumeUseCase.invoke(
                resumeId = resumeId
            )
        }
    }
}