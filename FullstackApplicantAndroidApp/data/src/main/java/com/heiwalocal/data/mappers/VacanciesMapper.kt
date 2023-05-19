package com.heiwalocal.data.mappers

import com.heiwalocal.data.entities.VacanciesByKeywordsResponse
import com.heiwalocal.data.mappers.base.BaseMapper
import com.heiwalocal.domain.entities.Vacancies
import com.heiwalocal.domain.entities.Vacancy

class VacanciesMapper: BaseMapper<VacanciesByKeywordsResponse, Vacancies> {
    override fun transform(type: VacanciesByKeywordsResponse): Vacancies {
        return Vacancies(
            count = type.count,
            items = type.items.map {
                Vacancy(
                    organizationName = it.organizationName,
                    organizationLogoUrl = it.organizationLogoUrl,
                    jobTitle = it.jobTitle,
                    salary = it.salary,
                    address = it.address
                )
            }
        )
    }

    override fun transformToRepository(type: Vacancies): VacanciesByKeywordsResponse {
        TODO("Not yet implemented")
    }

}