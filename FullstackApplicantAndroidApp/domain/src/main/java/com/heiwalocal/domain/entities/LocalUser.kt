package com.heiwalocal.domain.entities

data class LocalUser(
    var id: Long? = null,
    var currentUser: Boolean,
    var accessToken: String,
)