package com.heiwalocal.domain.usecases

import com.heiwalocal.domain.entities.Applicant
import com.heiwalocal.domain.repositories.ApplicantRepository
import com.heiwalocal.domain.repositories.UserRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetApplicantUseCase: KoinComponent {
    private val applicantRepository: ApplicantRepository by inject()
    private val userRepository: UserRepository by inject()

    operator fun invoke(): Applicant? {
        val accessToken = userRepository.getCurrentUser()?.accessToken ?: ""

        return applicantRepository.getApplicant(
            accessToken = accessToken
        )
    }
}