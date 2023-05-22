package com.heiwalocal.fullstackapplicantandroidapp.screens.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.heiwalocal.domain.entities.Applicant
import com.heiwalocal.domain.entities.Resume
import com.heiwalocal.domain.usecases.GetApplicantUseCase
import com.heiwalocal.domain.usecases.LogoutUseCase
import com.heiwalocal.fullstackapplicantandroidapp.base.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileViewModel(
    private val logoutUseCase: LogoutUseCase,
    private val getApplicantUseCase: GetApplicantUseCase,
): BaseViewModel() {
    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }
    private val _applicant = MutableLiveData<Applicant?>()
    val applicant: LiveData<Applicant?>
        get() { return _applicant }

    suspend fun logout(): Boolean {
        return withContext(Dispatchers.IO + coroutineExceptionHandler) {
            logoutUseCase.invoke()
        }
    }

    fun getApplicant() {
        launch(Dispatchers.IO + coroutineExceptionHandler) {
            _applicant.postValue(
                getApplicantUseCase.invoke()
            )
        }
    }
}