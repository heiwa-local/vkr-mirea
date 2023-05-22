package com.heiwalocal.data.mappers

import com.heiwalocal.data.entities.JobPostingResponse
import com.heiwalocal.data.mappers.base.BaseMapper
import com.heiwalocal.domain.entities.JobPosting

class JobPostingMapper: BaseMapper<JobPostingResponse, JobPosting> {
    override fun transform(type: JobPostingResponse): JobPosting {
        return JobPosting(
            id = type.id,
            vacancyId = type.vacancyId,
            resumeId = type.resumeId,
            jobTitle = type.jobTitle,
            organizationName = type.organizationName,
            organizationLogoUrl = type.organizationLogoUrl,
            status = type.status,
            datetime = type.datetime
        )
    }

    override fun transformToRepository(type: JobPosting): JobPostingResponse {
        TODO("Not yet implemented")
    }
}