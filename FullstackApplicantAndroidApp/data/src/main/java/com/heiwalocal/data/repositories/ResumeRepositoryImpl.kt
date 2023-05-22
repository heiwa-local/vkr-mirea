package com.heiwalocal.data.repositories

import com.heiwalocal.data.entities.post.CreateResumeBody
import com.heiwalocal.data.entities.post.DeleteJobPostingBody
import com.heiwalocal.data.entities.post.DeleteResumeBody
import com.heiwalocal.data.mappers.ResumeMapper
import com.heiwalocal.data.services.remote.fullstackapi.FullstackApiService
import com.heiwalocal.domain.entities.Resume
import com.heiwalocal.domain.repositories.ResumeRepository

class ResumeRepositoryImpl(
    private val fullstackApiService: FullstackApiService
): ResumeRepository {

    private val mapper = ResumeMapper()

    override fun getResumes(accessToken: String): List<Resume>? {
        val response = fullstackApiService.getResumes(
            accessToken = accessToken
        )

        return response?.items?.map { mapper.transform(it) }
    }

    override fun createResume(
        jobTitle: String,
        salary: String,
        skills: String,
        education: String,
        workExperience: String,
        gradeId: String,
        address: String,
        accessToken: String
    ): String? {
        return fullstackApiService.createResume(
            CreateResumeBody(
                jobTitle= jobTitle,
                salary= salary,
                skills= skills,
                education= education,
                workExperience= workExperience,
                gradeId= gradeId,
                address=address
            ),
            accessToken= accessToken
        )?.status
    }

    override fun getResume(
        resumeId: String
    ): Resume? {
        val response = fullstackApiService.getResume(
            resumeId = resumeId
        )
        return if (response != null) {
            mapper.transform(response)
        } else {
            null
        }
    }

    override fun deleteResume(resumeId: String, accessToken: String): String? {
        return fullstackApiService.deleteResume(
            body = DeleteResumeBody(
                resumeId = resumeId
            ),
            accessToken = accessToken
        )?.status
    }

}