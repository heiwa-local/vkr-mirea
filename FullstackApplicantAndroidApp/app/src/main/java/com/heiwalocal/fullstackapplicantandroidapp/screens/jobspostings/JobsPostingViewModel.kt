package com.heiwalocal.fullstackapplicantandroidapp.screens.jobspostings

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.heiwalocal.domain.entities.JobPosting
import com.heiwalocal.domain.entities.Resume
import com.heiwalocal.domain.usecases.GetJobsPostingsUseCase
import com.heiwalocal.fullstackapplicantandroidapp.base.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JobsPostingViewModel(
    private val getJobsPostingsUseCase: GetJobsPostingsUseCase
): BaseViewModel() {
    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }

    private val _jobsPostings = MutableLiveData<List<JobPosting>?>()
    val jobsPostings: LiveData<List<JobPosting>?>
        get() { return _jobsPostings }

    fun getJobsPostings() = launch(Dispatchers.IO + coroutineExceptionHandler) {
        _jobsPostings.postValue(
            getJobsPostingsUseCase.invoke()
        )
    }
}