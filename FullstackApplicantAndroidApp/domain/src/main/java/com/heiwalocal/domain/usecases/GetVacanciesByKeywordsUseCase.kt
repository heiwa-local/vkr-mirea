package com.heiwalocal.domain.usecases

import com.heiwalocal.domain.entities.Vacancies
import com.heiwalocal.domain.entities.Vacancy
import com.heiwalocal.domain.repositories.VacancyRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetVacanciesByKeywordsUseCase: KoinComponent {
    private val vacancyRepository: VacancyRepository by inject()

    operator fun invoke(
        keywords: String,
        type: String?,
        salary: String?,
        tags: String?,
    ): List<Vacancy>? {
        return vacancyRepository.getVacanciesByKeywords(
            keywords = keywords,
            type = type,
            salary = salary,
            tags = tags
        )
    }
}