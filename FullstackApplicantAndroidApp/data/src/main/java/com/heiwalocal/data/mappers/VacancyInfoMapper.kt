package com.heiwalocal.data.mappers

import com.heiwalocal.data.entities.VacancyInfoByVacancyIdResponse
import com.heiwalocal.data.mappers.base.BaseMapper
import com.heiwalocal.domain.entities.VacancyInfo

class VacancyInfoMapper: BaseMapper<VacancyInfoByVacancyIdResponse, VacancyInfo> {
    override fun transform(type: VacancyInfoByVacancyIdResponse): VacancyInfo {
        return VacancyInfo(
            id = type.id,
            organizationName = type.organizationName,
            organizationLogoUrl = type.organizationLogoUrl,
            organizationDescription = type.organizationDescription,
            jobTitle = type.jobTitle,
            salary = type.salary,
            address = type.address,
            employment = type.employment,
            description = type.description,
            grade = type.grade,
            direction = type.direction,
            jobPostingId = type.jobPostingId,
        )
    }

    override fun transformToRepository(type: VacancyInfo): VacancyInfoByVacancyIdResponse {
        TODO("Not yet implemented")
    }

}