package com.heiwalocal.data.entities

import com.google.gson.annotations.SerializedName

data class VacanciesByKeywordsResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("items") val items: List<VacancyResponse>,
)

data class VacancyResponse(
    @SerializedName("id") val id: String,
    @SerializedName("organization_name") val organizationName: String,
    @SerializedName("organization_logo_url") val organizationLogoUrl: String,
    @SerializedName("job_title") val jobTitle: String,
    @SerializedName("salary") val salary: Double,
    @SerializedName("address") val address: String
)
