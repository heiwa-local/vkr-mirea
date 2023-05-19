package com.heiwalocal.data.remote.fullstackapi

import com.heiwalocal.data.entities.VacanciesByKeywordsResponse

class FullstackApiService {
    private val api = FullstackApiInterface
        .getInstance()
        .create(FullstackApiInterface::class.java)

    fun getVacanciesByKeywords(keywords: String): VacanciesByKeywordsResponse? {
        val call = api.getVacanciesByKeywords(
            keywords = keywords,
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