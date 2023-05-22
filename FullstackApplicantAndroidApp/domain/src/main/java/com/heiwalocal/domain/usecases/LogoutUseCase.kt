package com.heiwalocal.domain.usecases

import com.heiwalocal.domain.repositories.UserRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LogoutUseCase: KoinComponent {
    private val userRepository: UserRepository by inject()

    operator fun invoke():Boolean {
        return try {
            userRepository.deleteUsers()
            true
        } catch (e: Exception) {
            false
        }
    }
}