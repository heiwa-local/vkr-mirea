package com.heiwalocal.data.entities

import com.google.gson.annotations.SerializedName

data class GradeResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
)
