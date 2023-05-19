package com.heiwalocal.domain.repositories

import com.heiwalocal.domain.entities.Vacancies
import com.heiwalocal.domain.entities.Vacancy

interface VacancyRepository {
    fun getVacanciesByKeywords(keywords: String): Vacancies?

}