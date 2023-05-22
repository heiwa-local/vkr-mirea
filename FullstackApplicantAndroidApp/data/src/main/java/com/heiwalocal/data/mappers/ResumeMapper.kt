package com.heiwalocal.data.mappers

import com.heiwalocal.data.entities.ResumeResponse
import com.heiwalocal.data.mappers.base.BaseMapper
import com.heiwalocal.domain.entities.Resume

class ResumeMapper: BaseMapper<ResumeResponse, Resume> {
    override fun transform(type: ResumeResponse): Resume {
        return Resume(
            id = type.id,
            applicantId = type.applicantId,
            jobTitle = type.jobTitle,
            grade = type.grade,
            address = type.address,
            salary = type.salary,
            skills = type.skills,
            education = type.education,
            workExperience = type.workExperience,
            datetime = type.datetime
        )
    }

    override fun transformToRepository(type: Resume): ResumeResponse {
        TODO("Not yet implemented")
    }
}