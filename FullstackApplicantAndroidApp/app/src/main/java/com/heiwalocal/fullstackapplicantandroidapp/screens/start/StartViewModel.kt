package com.heiwalocal.fullstackapplicantandroidapp.screens.start

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.heiwalocal.domain.usecases.CheckAuthUseCase
import com.heiwalocal.fullstackapplicantandroidapp.base.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StartViewModel(
    private val checkAuthUseCase: CheckAuthUseCase
): BaseViewModel() {
    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }

    private val _isAuth = MutableLiveData<Boolean>()
    val isAuth: LiveData<Boolean>
        get() { return _isAuth }

    suspend fun checkAuth(): Boolean {
        return withContext(Dispatchers.IO + coroutineExceptionHandler) {
            checkAuthUseCase.invoke()
        }
    }
}