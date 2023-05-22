package com.heiwalocal.domain.usecases

import com.heiwalocal.domain.entities.VacancyInfo
import com.heiwalocal.domain.repositories.UserRepository
import com.heiwalocal.domain.repositories.VacancyRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetVacancyInfoByVacancyIdUseCase: KoinComponent {
    private val vacancyRepository: VacancyRepository by inject()
    private val userRepository: UserRepository by inject()

    operator fun invoke(
        vacancyId: String,
    ): VacancyInfo? {
        val accessToken = userRepository.getCurrentUser()?.accessToken ?: ""
        return vacancyRepository.getVacancyInfoByVacancyId(
            vacancyId = vacancyId,
            accessToken= accessToken
        )
    }
}