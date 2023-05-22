package com.heiwalocal.domain.repositories

import com.heiwalocal.domain.entities.Vacancies
import com.heiwalocal.domain.entities.Vacancy
import com.heiwalocal.domain.entities.VacancyInfo

interface VacancyRepository {
    fun getVacanciesByKeywords(
        keywords: String,
        type: String?,
        salary: String?,
        tags: String?
    ): List<Vacancy>?

    fun getVacancyInfoByVacancyId(
        vacancyId: String,
        accessToken: String
    ): VacancyInfo?

    fun getLastAddedVacancies(): List<Vacancy>?

    fun getRecommendedVacancies(
        accessToken: String
    ): List<Vacancy>?

}