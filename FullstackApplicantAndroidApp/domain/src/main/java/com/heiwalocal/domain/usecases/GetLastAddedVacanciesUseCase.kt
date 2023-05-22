package com.heiwalocal.domain.usecases

import com.heiwalocal.domain.entities.Vacancy
import com.heiwalocal.domain.repositories.VacancyRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetLastAddedVacanciesUseCase: KoinComponent {
    private val vacancyRepository: VacancyRepository by inject()

    operator fun invoke(): List<Vacancy>? {
        return vacancyRepository.getLastAddedVacancies()
    }
}