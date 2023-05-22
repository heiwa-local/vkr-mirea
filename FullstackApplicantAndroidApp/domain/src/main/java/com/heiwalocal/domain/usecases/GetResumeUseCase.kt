package com.heiwalocal.domain.usecases

import com.heiwalocal.domain.entities.Resume
import com.heiwalocal.domain.repositories.ResumeRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetResumeUseCase: KoinComponent {
    private val resumeRepository: ResumeRepository by inject()

    operator fun invoke(
        resumeId: String
    ): Resume? {
        return resumeRepository.getResume(
            resumeId=resumeId
        )
    }
}