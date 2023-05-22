package com.heiwalocal.fullstackapplicantandroidapp.screens.resumes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.heiwalocal.domain.entities.Direction
import com.heiwalocal.domain.entities.Resume
import com.heiwalocal.domain.usecases.GetResumesUseCase
import com.heiwalocal.fullstackapplicantandroidapp.base.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ResumesViewModel(
    private val getResumesUseCase: GetResumesUseCase
): BaseViewModel() {
    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }

    private val _resumes = MutableLiveData<List<Resume>?>()
    val resumes: LiveData<List<Resume>?>
        get() { return _resumes }

    fun getResumes() = launch(Dispatchers.IO + coroutineExceptionHandler) {
        _resumes.postValue(
            getResumesUseCase.invoke()
        )
    }
}