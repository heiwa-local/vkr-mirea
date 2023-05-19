package com.heiwalocal.data.remote.fullstackapi

import com.heiwalocal.data.entities.VacanciesByKeywordsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "http://10.0.2.2:8080/api/v1/"

interface FullstackApiInterface {
    @GET("vacancies")
    fun getVacanciesByKeywords(@Query("keywords") keywords: String): Call<VacanciesByKeywordsResponse>

    companion object ApiUtilities {

        fun getInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}