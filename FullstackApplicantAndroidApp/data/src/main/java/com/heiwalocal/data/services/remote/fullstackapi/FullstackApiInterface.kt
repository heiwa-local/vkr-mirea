package com.heiwalocal.data.services.remote.fullstackapi

import com.heiwalocal.data.entities.*
import com.heiwalocal.data.entities.base.ListResponse
import com.heiwalocal.data.entities.base.PostResponse
import com.heiwalocal.data.entities.post.*
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.util.Objects

const val BASE_URL = "http://10.0.2.2:8081/api/v1/"

interface FullstackApiInterface {
    companion object ApiUtilities {

        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
    @GET("vacancies")
    fun getVacanciesByKeywords(
        @Query("keywords") keywords: String,
        @Query("direction_id") directionId: String? = null,
        @Query("salary") salary: String? = null,
        @Query("employments") employments: String? = null,
    ): Call<ListResponse<VacancyResponse>>

    @GET("vacancy_info")
    fun getVacancyInfoByVacancyId(
        @Query("vacancy_id") vacancyId: String,
        @Header("Authorization") authHeader: String
    ): Call<VacancyInfoByVacancyIdResponse>

    @GET("resumes")
    fun getResumes(
        @Header("Authorization") authHeader: String
    ): Call<ListResponse<ResumeResponse>>

    @POST("job_posting")
    fun postJobPosting(
        @Body jobPostingBody: JobPostingBody,
        @Header("Authorization") authHeader: String
    ): Call<PostResponse>

    @POST("update_token")
    fun updateToken(
        @Header("Authorization") authHeader: String
    ): Call<TokenResponse>

    @POST("login")
    fun getAccessToken(
        @Body body: LoginBody
    ): Call<TokenResponse>

    @POST("signup")
    fun signUp(
        @Body body: SignUpBody
    ): Call<PostResponse>

    @GET("directions")
    fun getDirections(): Call<ListResponse<DirectionResponse>>

    @POST("resume")
    fun createResume(
        @Body body: CreateResumeBody,
        @Header("Authorization") authHeader: String
    ): Call<PostResponse>

    @GET("grades")
    fun getGrades(): Call<ListResponse<GradeResponse>>

    @GET("jobs_postings")
    fun getJobPostings(
        @Header("Authorization") authHeader: String
    ): Call<ListResponse<JobPostingResponse>>

    @POST("job_posting/delete")
    fun deleteJobPostings(
        @Body body: DeleteJobPostingBody,
        @Header("Authorization") authHeader: String
    ): Call<PostResponse>

    @GET("vacancies/last_added")
    fun getLastAddedVacancies(): Call<ListResponse<VacancyResponse>>

    @GET("vacancies/recommended")
    fun getRecommendedVacancies(
        @Header("Authorization") authHeader: String
    ): Call<ListResponse<VacancyResponse>>

    @GET("resume")
    fun getResume(
        @Query("resume_id") resumeId: String,
        ): Call<ResumeResponse>

    @POST("resume/delete")
    fun deleteResume(
        @Body body: DeleteResumeBody,
        @Header("Authorization") authHeader: String
    ): Call<PostResponse>

    @GET("applicant")
    fun getApplicant(
        @Header("Authorization") authHeader: String
    ): Call<ApplicantResponse>

}