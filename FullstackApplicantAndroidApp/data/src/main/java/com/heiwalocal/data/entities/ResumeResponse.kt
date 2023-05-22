package com.heiwalocal.data.entities

import com.google.gson.annotations.SerializedName

data class ResumeResponse(
    @SerializedName("id") val id: String? = null,
    @SerializedName("applicant_id") val applicantId: String? = null,
    @SerializedName("job_title") val jobTitle: String? = null,
    @SerializedName("grade") val grade: String? = null,
    @SerializedName("address") val address: String? = null,
    @SerializedName("salary") val salary: Double? = null,
    @SerializedName("skills") val skills: String? = null,
    @SerializedName("education") val education: String? = null,
    @SerializedName("work_experience") val workExperience: String? = null,
    @SerializedName("datetime") val datetime: String? = null,
)