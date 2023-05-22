package com.heiwalocal.domain.repositories

import com.heiwalocal.domain.entities.JobPosting

interface JobPostingRepository {
    fun postJobPosting(vacancyId: String, resumeId: String): String?

    fun getJobPostings(accessToken: String): List<JobPosting>?

    fun deleteJobPosting(
        jobPostingId: String,
        accessToken: String
    ): String?
}