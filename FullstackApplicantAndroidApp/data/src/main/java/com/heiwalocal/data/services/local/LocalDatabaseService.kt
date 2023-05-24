package com.heiwalocal.data.services.local

import com.heiwalocal.data.services.local.database.LocalDatabase
import com.heiwalocal.data.services.local.dto.UserPojo

class LocalDatabaseService(
    private val roomDatabase: LocalDatabase

) {
    fun insertUser(accessToken: String) {
        roomDatabase.userDao().insertUser(
            UserPojo(
                currentUser = true,
                accessToken = accessToken
            )
        )
    }

    fun getCurrentUser(): UserPojo? {
        return if (roomDatabase.userDao().getCurrentUser().isNotEmpty()) {
            roomDatabase.userDao().getCurrentUser()[0]
        } else {
            null
        }
    }

    fun deleteUsers() {
        roomDatabase.userDao().deleteUsers()
    }
}