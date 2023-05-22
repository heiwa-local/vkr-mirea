package com.heiwalocal.data.entities.base

import com.google.gson.annotations.SerializedName

data class ListResponse<T>(
    @SerializedName("items") val items: List<T>
)
