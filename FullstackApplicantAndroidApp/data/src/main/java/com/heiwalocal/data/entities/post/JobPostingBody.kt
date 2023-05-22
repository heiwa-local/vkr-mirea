package com.heiwalocal.data.entities.post

import com.google.gson.annotations.SerializedName

data class JobPostingBody(
    @SerializedName("vacancy_id") val vacancyId: String,
    @SerializedName("resume_id") val resumeId: String,
)
