package com.heiwalocal.domain.usecases

import com.heiwalocal.domain.entities.Vacancies
import com.heiwalocal.domain.repositories.VacancyRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetVacanciesByKeywordsUseCase: KoinComponent {
    private val vacancyRepository: VacancyRepository by inject()

    operator fun invoke(keywords: String): Vacancies? {
        return vacancyRepository.getVacanciesByKeywords(keywords)
    }
}