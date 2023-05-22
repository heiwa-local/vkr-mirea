package com.heiwalocal.data.entities.post

import com.google.gson.annotations.SerializedName

data class SignUpBody(
    @SerializedName("name") val name: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
)