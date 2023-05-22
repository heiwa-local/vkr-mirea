package com.heiwalocal.data.repositories

import com.heiwalocal.data.mappers.ApplicantMapper
import com.heiwalocal.data.services.remote.fullstackapi.FullstackApiService
import com.heiwalocal.domain.entities.Applicant
import com.heiwalocal.domain.repositories.ApplicantRepository

class ApplicantRepositoryImpl(
    private val fullstackApiService: FullstackApiService
): ApplicantRepository {
    private val mapper = ApplicantMapper()

    override fun getApplicant(accessToken: String): Applicant? {
        val response = fullstackApiService.getApplicant(
            accessToken = accessToken
        )
        return if (response != null) {
            mapper.transform(response)
        } else {
            null
        }
    }
}