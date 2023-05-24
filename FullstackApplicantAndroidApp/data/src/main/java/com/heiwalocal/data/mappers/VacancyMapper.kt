package com.heiwalocal.data.mappers

import com.heiwalocal.data.entities.VacancyResponse
import com.heiwalocal.data.mappers.base.BaseMapper
import com.heiwalocal.domain.entities.Vacancies
import com.heiwalocal.domain.entities.Vacancy

class VacancyMapper: BaseMapper<VacancyResponse, Vacancy> {
    override fun transform(type: VacancyResponse): Vacancy {
        return Vacancy(
            id = type.id,
            organizationName = type.organizationName,
            organizationLogoUrl = type.organizationLogoUrl,
            jobTitle = type.jobTitle,
            salary = type.salary,
            address = type.address
        )
    }

    override fun transformToRepository(type: Vacancy): VacancyResponse {
        TODO("Not yet implemented")
    }

}