package com.heiwalocal.data.repositories

import com.heiwalocal.data.entities.post.DeleteJobPostingBody
import com.heiwalocal.data.entities.post.JobPostingBody
import com.heiwalocal.data.mappers.JobPostingMapper
import com.heiwalocal.data.services.local.LocalDatabaseService
import com.heiwalocal.data.services.remote.fullstackapi.FullstackApiService
import com.heiwalocal.domain.entities.JobPosting
import com.heiwalocal.domain.repositories.JobPostingRepository

class JobPostingRepositoryImpl(
    private val fullstackApiService: FullstackApiService,
    private val roomDatabaseService: LocalDatabaseService,
): JobPostingRepository {

    private val mapper = JobPostingMapper()

    override fun postJobPosting(vacancyId: String, resumeId: String): String? {
//        Log.e("DDDD", roomDatabaseService.getAccess())
        val accessToken = roomDatabaseService.getCurrentUser()?.accessToken
//        roomDatabaseService.insertAccess()
        return fullstackApiService.postJobPosting(
            JobPostingBody(
                vacancyId = vacancyId,
                resumeId = resumeId
            ),
            accessToken = accessToken!!
        )?.status
    }

    override fun getJobPostings(accessToken: String): List<JobPosting>? {
        return fullstackApiService.getJobPostings(
            accessToken = accessToken
        )?.items?.map { mapper.transform(it) }
    }

    override fun deleteJobPosting(jobPostingId: String, accessToken: String): String? {
        return fullstackApiService.deleteJobPosting(
            body = DeleteJobPostingBody(
                jobPostingId = jobPostingId
            ),
            accessToken = accessToken
        )?.status
    }
}