package com.heiwalocal.data.repositories

import com.heiwalocal.data.mappers.VacanciesMapper
import com.heiwalocal.data.remote.fullstackapi.FullstackApiService
import com.heiwalocal.domain.entities.Vacancies
import com.heiwalocal.domain.entities.Vacancy
import com.heiwalocal.domain.repositories.VacancyRepository

class VacancyRepositoryImpl(
    private val fullstackApiService: FullstackApiService
): VacancyRepository {

    private val vacanciesMapper = VacanciesMapper()

    override fun getVacanciesByKeywords(keywords: String): Vacancies? {
        val response = fullstackApiService.getVacanciesByKeywords(keywords)

        if (response != null) {
            return vacanciesMapper.transform(response)
        }
        return null
    }
}