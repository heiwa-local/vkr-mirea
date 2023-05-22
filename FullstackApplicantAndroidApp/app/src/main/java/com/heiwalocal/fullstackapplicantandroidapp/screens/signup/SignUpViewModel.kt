package com.heiwalocal.fullstackapplicantandroidapp.screens.signup

import com.heiwalocal.domain.usecases.SignUpUseCase
import com.heiwalocal.fullstackapplicantandroidapp.base.BaseViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SignUpViewModel(
    private val signUpUseCase: SignUpUseCase
): BaseViewModel() {
    val coroutineExceptionHandler = CoroutineExceptionHandler{_, throwable ->
        throwable.printStackTrace()
    }

    suspend fun signUp(
        name: String,
        phone: String,
        email: String,
        password: String
    ): Boolean {
        return withContext(Dispatchers.IO + coroutineExceptionHandler) {
            signUpUseCase.invoke(
                name = name,
                phone = phone,
                email = email,
                password = password
            )
        }
    }
}