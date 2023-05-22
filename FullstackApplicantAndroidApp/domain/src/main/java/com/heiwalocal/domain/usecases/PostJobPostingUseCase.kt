package com.heiwalocal.domain.usecases

import com.heiwalocal.domain.entities.VacancyInfo
import com.heiwalocal.domain.repositories.JobPostingRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class PostJobPostingUseCase: KoinComponent {
    private val jobPostingRepository : JobPostingRepository by inject()

    operator fun invoke(
        vacancyId: String,
        resumeId: String,
    ): Boolean {
        val response = jobPostingRepository.postJobPosting(
            vacancyId = vacancyId,
            resumeId = resumeId
        )
        return response == "success"
    }
}