package com.heiwalocal.domain.usecases

import com.heiwalocal.domain.repositories.JobPostingRepository
import com.heiwalocal.domain.repositories.UserRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DeleteJobPostingUseCase: KoinComponent {
    private val jobPostingRepository: JobPostingRepository by inject()
    private val userRepository: UserRepository by inject()

    operator fun invoke(jobPostingId: String): Boolean {
        val accessToken = userRepository.getCurrentUser()?.accessToken ?: ""

        return jobPostingRepository.deleteJobPosting(
            jobPostingId=jobPostingId,
            accessToken=accessToken
        ) == "success"
    }
}