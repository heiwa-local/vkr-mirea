package com.heiwalocal.domain.usecases

import android.util.Log
import com.heiwalocal.domain.repositories.UserRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CheckAuthUseCase: KoinComponent {
    private val userRepository: UserRepository by inject()

    operator fun invoke(): Boolean {
        Log.e("tess", "usecase")
        val currentUser = userRepository.getCurrentUser()
        if (currentUser != null) {
            return true
        }
        return false
    }
}