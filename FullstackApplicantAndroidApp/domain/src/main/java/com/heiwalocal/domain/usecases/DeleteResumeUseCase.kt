package com.heiwalocal.domain.usecases

import com.heiwalocal.domain.repositories.ResumeRepository
import com.heiwalocal.domain.repositories.UserRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DeleteResumeUseCase: KoinComponent {
    private val resumeRepository: ResumeRepository by inject()
    private val userRepository: UserRepository by inject()

    operator fun invoke(
        resumeId: String
    ): Boolean {
        val accessToken = userRepository.getCurrentUser()?.accessToken ?: ""
        val response = resumeRepository.deleteResume(
            resumeId = resumeId,
            accessToken = accessToken
        )
        return response == "success"
    }
}