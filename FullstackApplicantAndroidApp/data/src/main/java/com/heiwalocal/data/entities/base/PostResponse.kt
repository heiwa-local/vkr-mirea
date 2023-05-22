package com.heiwalocal.data.entities.base

import com.google.gson.annotations.SerializedName

data class PostResponse(
    @SerializedName("status") val status: String,
)