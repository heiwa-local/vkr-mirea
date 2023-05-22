package com.heiwalocal.domain.usecases

import com.heiwalocal.domain.entities.Resume
import com.heiwalocal.domain.entities.Resumes
import com.heiwalocal.domain.repositories.ResumeRepository
import com.heiwalocal.domain.repositories.UserRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetResumesUseCase: KoinComponent {
    private val resumeRepository: ResumeRepository by inject()
    private val userRepository: UserRepository by inject()

    operator fun invoke(): List<Resume>? {
        val accessToken = userRepository.getCurrentUser()?.accessToken ?: ""
        return resumeRepository.getResumes(
            accessToken = accessToken
        )
    }
}