package com.heiwalocal.data.entities

import com.google.gson.annotations.SerializedName

data class VacancyInfoByVacancyIdResponse(
    @SerializedName("id") val id: String,
    @SerializedName("organization_name") val organizationName: String,
    @SerializedName("organization_logo_url") val organizationLogoUrl: String,
    @SerializedName("organization_description") val organizationDescription: String,
    @SerializedName("job_title") val jobTitle: String,
    @SerializedName("salary") val salary: Double,
    @SerializedName("address") val address: String,
    @SerializedName("employment") val employment: String,
    @SerializedName("description") val description: String,
    @SerializedName("grade") val grade: String,
    @SerializedName("direction") val direction: String? = null,
    @SerializedName("job_posting_id") val jobPostingId: String? = null,
)
