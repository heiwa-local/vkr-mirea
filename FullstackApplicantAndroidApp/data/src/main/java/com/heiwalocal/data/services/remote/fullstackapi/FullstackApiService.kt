package com.heiwalocal.data.services.remote.fullstackapi

import android.util.Log
import com.heiwalocal.data.entities.*
import com.heiwalocal.data.entities.base.ListResponse
import com.heiwalocal.data.entities.base.PostResponse
import com.heiwalocal.data.entities.post.*
import com.heiwalocal.domain.entities.Resume
import com.heiwalocal.domain.entities.Vacancy
import org.json.JSONObject
import java.util.Objects

class FullstackApiService {
    private val api = FullstackApiInterface.getInstance()
        .create(FullstackApiInterface::class.java)

    fun getVacanciesByKeywords(
        keywords: String,
        type: String?,
        salary: String?,
        employments: String?
    ): ListResponse<VacancyResponse>? {
        val call = api.getVacanciesByKeywords(
            keywords = keywords.replace(" ", "%"),
            directionId = if (type?.trim()?.length == 0) {null} else {type},
            salary = if (salary?.trim()?.length == 0) {null} else {salary},
            employments = if (employments?.trim()?.length == 0) {null} else {employments}

        )
        val response = call.execute()

        if (response.body() != null) {
            if (response.isSuccessful) {
                return response.body()
            }
        }
        return null
    }

    fun getVacancyInfoByVacancyId(
        vacancyId: String,
        accessToken: String
    ): VacancyInfoByVacancyIdResponse? {
        val call = api.getVacancyInfoByVacancyId(
            vacancyId = vacancyId,
            authHeader = "Bearer $accessToken"
        )
        val response = call.execute()

        if (response.body() != null) {
            if (response.isSuccessful) {
                return response.body()
            }
        }
        return null
    }

    fun getResumes(
        accessToken: String
    ): ListResponse<ResumeResponse>? {
        val call = api.getResumes(
            authHeader = "Bearer $accessToken"
        )
        val response = call.execute()

        if (response.body() != null) {
            if (response.isSuccessful) {
                return response.body()
            }
        }
        return null
    }

    fun postJobPosting(
        jobPostingBody: JobPostingBody,
        accessToken: String
    ): PostResponse? {
        val call = api.postJobPosting(
            jobPostingBody = jobPostingBody,
            authHeader = "Bearer $accessToken"
        )
        val response = call.execute()

        if (response.body() != null) {
            if (response.isSuccessful) {
                return response.body()
            }
        }
        return null
    }

    fun updateToken(
        accessToken: String
    ): TokenResponse? {
        val call = api.updateToken(
            authHeader = "Bearer $accessToken"
        )
        val response = call.execute()

        if (response.body() != null) {
            if (response.isSuccessful) {
                return response.body()
            }
        }
        return null
    }

    fun getAccessToken(
        email: String,
        password: String
    ): TokenResponse? {
        val call = api.getAccessToken(
            body = LoginBody(
                email = email,
                password = password
            )
        )
        val response = call.execute()

        if (response.body() != null) {
            if (response.isSuccessful) {
                return response.body()
            }
        }
        return null
    }

    fun signUp(
        body: SignUpBody
    ): PostResponse? {
        val call = api.signUp(
            body = body
        )
        val response = call.execute()

        if (response.body() != null) {
            if (response.isSuccessful) {
                return response.body()
            }
        }
        return null
    }

    fun getDirections(): ListResponse<DirectionResponse>? {
        val call = api.getDirections()

        val response = call.execute()

        if (response.body() != null) {
            if (response.isSuccessful) {
                return response.body()
            }
        }
        return null
    }

    fun createResume(
        body: CreateResumeBody,
        accessToken: String
    ): PostResponse? {
        val call = api.createResume(
            body = body,
            authHeader = "Bearer $accessToken"
        )
        val response = call.execute()

        if (response.body() != null) {
            if (response.isSuccessful) {
                return response.body()
            }
        }
        return null
    }

    fun getGrades(): ListResponse<GradeResponse>? {
        val call = api.getGrades()

        val response = call.execute()

        if (response.body() != null) {
            if (response.isSuccessful) {
                return response.body()
            }
        }
        return null
    }

    fun getJobPostings(
        accessToken: String
    ): ListResponse<JobPostingResponse>? {
        val call = api.getJobPostings(
            authHeader = "Bearer $accessToken"
        )

        val response = call.execute()

        if (response.body() != null) {
            if (response.isSuccessful) {
                return response.body()
            }
        }
        return null
    }

    fun deleteJobPosting(
        body: DeleteJobPostingBody,
        accessToken: String,
    ): PostResponse? {
        val call = api.deleteJobPostings(
            body = body,
            authHeader = "Bearer $accessToken"
        )

        val response = call.execute()

        if (response.body() != null) {
            if (response.isSuccessful) {
                return response.body()
            }
        }
        return null
    }

    fun getLastAddedVacancies(): ListResponse<VacancyResponse>? {
        val call = api.getLastAddedVacancies()

        val response = call.execute()

        if (response.body() != null) {
            if (response.isSuccessful) {
                return response.body()
            }
        }
        return null
    }

    fun getRecommendedVacancies(
        accessToken: String
    ): ListResponse<VacancyResponse>? {
        val call = api.getRecommendedVacancies(
            authHeader = "Bearer $accessToken"
        )

        val response = call.execute()

        if (response.body() != null) {
            if (response.isSuccessful) {
                return response.body()
            }
        }
        return null
    }

    fun getResume(
        resumeId: String
    ): ResumeResponse? {
        val call = api.getResume(
            resumeId= resumeId
        )

        val response = call.execute()

        if (response.body() != null) {
            if (response.isSuccessful) {
                return response.body()
            }
        }
        return null
    }

    fun deleteResume(
        body: DeleteResumeBody,
        accessToken: String,
    ): PostResponse? {
        val call = api.deleteResume(
            body = body,
            authHeader = "Bearer $accessToken"
        )

        val response = call.execute()

        if (response.body() != null) {
            if (response.isSuccessful) {
                return response.body()
            }
        }
        return null
    }

    fun getApplicant(
        accessToken: String,
    ): ApplicantResponse? {
        val call = api.getApplicant(
            authHeader = "Bearer $accessToken"
        )

        val response = call.execute()

        if (response.body() != null) {
            if (response.isSuccessful) {
                return response.body()
            }
        }
        return null
    }
}