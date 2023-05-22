package com.heiwalocal.data.mappers

import com.heiwalocal.data.entities.ApplicantResponse
import com.heiwalocal.data.mappers.base.BaseMapper
import com.heiwalocal.domain.entities.Applicant

class ApplicantMapper: BaseMapper<ApplicantResponse, Applicant> {
    override fun transform(type: ApplicantResponse): Applicant {
        return Applicant(
            id = type.id,
            name = type.name,
            phone = type.phone,
            email = type.email
        )
    }

    override fun transformToRepository(type: Applicant): ApplicantResponse {
        TODO("Not yet implemented")
    }
}