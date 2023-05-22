package com.heiwalocal.domain.repositories

import com.heiwalocal.domain.entities.Applicant

interface ApplicantRepository {

    fun getApplicant(
        accessToken: String
    ): Applicant?
}