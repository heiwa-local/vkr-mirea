package com.heiwalocal.data.entities.post

import com.google.gson.annotations.SerializedName

data class DeleteJobPostingBody(
    @SerializedName("job_posting_id") val jobPostingId: String
)
