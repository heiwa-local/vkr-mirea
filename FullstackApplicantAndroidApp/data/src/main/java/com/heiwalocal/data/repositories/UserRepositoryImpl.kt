package com.heiwalocal.data.repositories

import com.heiwalocal.data.entities.post.SignUpBody
import com.heiwalocal.data.mappers.UserMapper
import com.heiwalocal.data.services.local.LocalDatabaseService
import com.heiwalocal.data.services.remote.fullstackapi.FullstackApiService
import com.heiwalocal.domain.entities.LocalUser
import com.heiwalocal.domain.repositories.UserRepository

class UserRepositoryImpl(
    private val fullstackApiService: FullstackApiService,
    private val localDatabaseService: LocalDatabaseService,
): UserRepository {

    private val mapper = UserMapper()

    override fun getCurrentUser(): LocalUser? {
        val currentUser = localDatabaseService.getCurrentUser()
        if (currentUser != null) {
            return mapper.transform(currentUser)
        }
        return null
    }

    override fun getNewAccessToken(user: LocalUser): String? {
        val token = fullstackApiService.updateToken(user.accessToken)
        if (token != null) {
            return token.accessToken
        }
        return  null
    }

    override fun updateUser(user: LocalUser) {
        TODO("Not yet implemented")
    }

    override fun getAccessToken(email: String, password: String): String? {
        return fullstackApiService.getAccessToken(
            email = email,
            password = password
        )?.accessToken

    }

    override fun createNewLocalUser(accessToken: String) {
        localDatabaseService.insertUser(
            accessToken = accessToken
        )
    }

    override fun deleteUsers() {
        localDatabaseService.deleteUsers()
    }

    override fun signUp(name: String, phone: String, email: String, password: String): String? {
        return fullstackApiService.signUp(
            SignUpBody(
                name = name,
                phone = phone,
                email = email,
                password = password
            )
        )?.status
    }
}