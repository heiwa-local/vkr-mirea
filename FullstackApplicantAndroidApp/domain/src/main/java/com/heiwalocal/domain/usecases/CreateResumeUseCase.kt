package com.heiwalocal.domain.usecases

import com.heiwalocal.domain.repositories.ResumeRepository
import com.heiwalocal.domain.repositories.UserRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class CreateResumeUseCase: KoinComponent {
    private val resumeRepository: ResumeRepository by inject()
    private val userRepository: UserRepository by inject()

    operator fun invoke(
        jobTitle: String,
        salary: String,
        skills: String,
        education: String,
        workExperience: String,
        gradeId: String,
        address: String
    ): Boolean {
        val currentUser = userRepository.getCurrentUser()
        val response = resumeRepository.createResume(
            jobTitle= jobTitle,
            salary= salary,
            skills= skills,
            education= education,
            workExperience= workExperience,
            gradeId= gradeId,
            address= address,
            accessToken= currentUser?.accessToken ?: ""
        )
        return response != null
    }
}