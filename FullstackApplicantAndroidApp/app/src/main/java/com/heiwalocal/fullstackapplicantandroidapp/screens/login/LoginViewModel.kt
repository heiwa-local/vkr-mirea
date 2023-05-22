package com.heiwalocal.fullstackapplicantandroidapp.screens.login

import com.heiwalocal.domain.usecases.LoginUseCase
import com.heiwalocal.fullstackapplicantandroidapp.base.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginViewModel(
    private val loginUseCase: LoginUseCase
): BaseViewModel() {
    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }

    suspend fun login(
        email: String,
        password: String
    ): Boolean {
        return withContext(Dispatchers.IO + coroutineExceptionHandler) {
            loginUseCase.invoke(
                email = email,
                password = password
            )
        }
    }
}