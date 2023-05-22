package com.heiwalocal.data.entities.post

import com.google.gson.annotations.SerializedName

data class DeleteResumeBody(
    @SerializedName("resume_id") val resumeId: String
)