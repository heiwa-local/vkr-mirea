package com.heiwalocal.data.entities

import com.google.gson.annotations.SerializedName

data class JobPostingResponse(
    @SerializedName("id") val id: String? = null,
    @SerializedName("vacancy_id") val vacancyId: String? = null,
    @SerializedName("resume_id") val resumeId: String? = null,
    @SerializedName("vacancy_job_title") val jobTitle: String? = null,
    @SerializedName("organization_name") val organizationName: String? = null,
    @SerializedName("organization_logo_url") val organizationLogoUrl: String? = null,
    @SerializedName("status") val status: String? = null,
    @SerializedName("datetime") val datetime: String? = null,
)
