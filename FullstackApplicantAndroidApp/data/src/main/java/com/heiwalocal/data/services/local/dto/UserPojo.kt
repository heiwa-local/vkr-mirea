package com.heiwalocal.data.services.local.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserPojo(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var currentUser: Boolean,
    var accessToken: String,
)
