package com.heiwalocal.data.entities.post

import com.google.gson.annotations.SerializedName

data class CreateResumeBody(
    @SerializedName("job_title") val jobTitle: String,
    @SerializedName("salary") val salary: String,
    @SerializedName("skills") val skills: String,
    @SerializedName("education") val education: String,
    @SerializedName("work_experience") val workExperience: String,
    @SerializedName("grade_id") val gradeId: String,
    @SerializedName("address") val address: String,
)
