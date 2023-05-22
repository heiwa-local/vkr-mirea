package com.heiwalocal.domain.usecases

import com.heiwalocal.domain.repositories.UserRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class SignUpUseCase: KoinComponent {
    private val userRepository: UserRepository by inject()

    operator fun invoke(
        name: String,
        phone: String,
        email: String,
        password: String
    ): Boolean {
        val response = userRepository.signUp(
            name = name,
            phone = phone,
            email = email,
            password = password
        )
        if (response != null) {
            if (response == "success") {
                val accessToken = userRepository.getAccessToken(
                    email = email,
                    password = password
                )
                if (accessToken != null) {
                    userRepository.createNewLocalUser(
                        accessToken = accessToken
                    )
                    return true
                }
            }
        }
        return false
    }
}