package com.heiwalocal.domain.usecases

import com.heiwalocal.domain.entities.Vacancy
import com.heiwalocal.domain.repositories.UserRepository
import com.heiwalocal.domain.repositories.VacancyRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetRecommendedVacanciesUseCase: KoinComponent {
    private val vacancyRepository: VacancyRepository by inject()
    private val userRepository: UserRepository by inject()

    operator fun invoke(): List<Vacancy>? {
        val accessToken = userRepository.getCurrentUser()?.accessToken ?: ""
        return vacancyRepository.getRecommendedVacancies(
            accessToken = accessToken
        )
    }
}