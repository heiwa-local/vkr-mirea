package com.heiwalocal.data.entities.post

import com.google.gson.annotations.SerializedName

data class VacancyByKeywordsBody(
    @SerializedName("keywords") val keywords: String,
    @SerializedName("direction") val direction: String? = null,
    @SerializedName("salary") val salary: String? = null,
    @SerializedName("region") val region: String? = null,
    @SerializedName("tags") val tags: String? = null
)
