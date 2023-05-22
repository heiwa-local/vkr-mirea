package com.heiwalocal.data.entities

import com.google.gson.annotations.SerializedName

data class ApplicantResponse(
    @SerializedName("id") val id: String? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("phone") val phone: String? = null,
    @SerializedName("email") val email: String? = null,
)