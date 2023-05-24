package com.heiwalocal.data.entities

import com.google.gson.annotations.SerializedName

data class DirectionResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
)
