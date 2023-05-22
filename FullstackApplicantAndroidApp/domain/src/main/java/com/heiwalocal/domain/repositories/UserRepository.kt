package com.heiwalocal.domain.repositories

import com.heiwalocal.domain.entities.LocalUser

interface UserRepository {
    fun getCurrentUser(): LocalUser?

    fun getNewAccessToken(user: LocalUser): String?

    fun updateUser(user: LocalUser)

    fun getAccessToken(email: String, password: String): String?

    fun createNewLocalUser(accessToken: String)

    fun deleteUsers()

    fun signUp(
        name: String,
        phone: String,
        email: String,
        password: String,
    ): String?
}