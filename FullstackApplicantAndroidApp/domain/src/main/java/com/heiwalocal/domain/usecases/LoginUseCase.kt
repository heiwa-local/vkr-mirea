package com.heiwalocal.domain.usecases

import com.heiwalocal.domain.repositories.UserRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LoginUseCase: KoinComponent {
    private val userRepository: UserRepository by inject()

    operator fun invoke(
        email: String,
        password: String
    ): Boolean {
        val accessToken = userRepository.getAccessToken(
            email = email,
            password = password
        )
        if (accessToken != null) {
            userRepository.createNewLocalUser(
                accessToken = accessToken
            )
            return true
        } else {
            return false
        }
    }
}