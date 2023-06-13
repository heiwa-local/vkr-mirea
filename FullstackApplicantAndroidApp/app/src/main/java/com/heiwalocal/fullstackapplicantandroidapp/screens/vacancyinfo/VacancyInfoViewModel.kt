package com.heiwalocal.fullstackapplicantandroidapp.screens.vacancyinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.heiwalocal.domain.entities.Resume
import com.heiwalocal.domain.entities.Resumes
import com.heiwalocal.domain.entities.VacancyInfo
import com.heiwalocal.domain.usecases.DeleteJobPostingUseCase
import com.heiwalocal.domain.usecases.GetResumesUseCase
import com.heiwalocal.domain.usecases.GetVacancyInfoByVacancyIdUseCase
import com.heiwalocal.domain.usecases.PostJobPostingUseCase
import com.heiwalocal.fullstackapplicantandroidapp.base.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class VacancyInfoViewModel(
    private val getVacancyInfoByVacancyIdUseCase: GetVacancyInfoByVacancyIdUseCase,
    private val getResumesByUserIdUseCase: GetResumesUseCase,
    private val postJobPostingUseCase: PostJobPostingUseCase,
    private val deleteJobPostingUseCase: DeleteJobPostingUseCase,
): BaseViewModel() {

    private val coroutineExceptionHandler = CoroutineExceptionHandler{ _, throwable ->
        throwable.printStackTrace()
    }
    private val _resumes = MutableLiveData<List<Resume>>()
    val resumes: LiveData<List<Resume>>
        get() { return _resumes }

    private val _vacancyInfo = MutableLiveData<VacancyInfo?>()
    val vacancyInfo: LiveData<VacancyInfo?>
        get() { return _vacancyInfo }

    suspend fun getVacancyInfoByVacancyId(
        vacancyId: String,
    ) {
        withContext(Dispatchers.IO + coroutineExceptionHandler) {
            _vacancyInfo.postValue(
                getVacancyInfoByVacancyIdUseCase.invoke(
                    vacancyId = vacancyId
                )
            )
        }
    }

    fun getResumesByUserId(
    ) = launch(Dispatchers.IO + coroutineExceptionHandler) {
        _resumes.postValue(
            getResumesByUserIdUseCase.invoke()
        )
    }

    suspend fun postJobPosting(
        vacancyId: String,
        resumeId: String
    ): Boolean {
        return withContext(Dispatchers.IO + coroutineExceptionHandler) {
            postJobPostingUseCase.invoke(vacancyId,resumeId)
        }
    }

    suspend fun deleteJobPosting(
        jobPostingId: String,
    ): Boolean {
        return withContext(Dispatchers.IO + coroutineExceptionHandler) {
            deleteJobPostingUseCase.invoke(jobPostingId = jobPostingId)
        }
    }
}