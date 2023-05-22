package com.heiwalocal.domain.repositories

import com.heiwalocal.domain.entities.Resume
import com.heiwalocal.domain.entities.Resumes

interface ResumeRepository {
    fun getResumes(accessToken: String): List<Resume>?

    fun createResume(
        jobTitle: String,
        salary: String,
        skills: String,
        education: String,
        workExperience: String,
        gradeId: String,
        address: String,
        accessToken: String
    ): String?

    fun getResume(resumeId: String): Resume?

    fun deleteResume(resumeId: String, accessToken: String): String?
}