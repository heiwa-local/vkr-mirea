package com.heiwalocal.data.services.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.heiwalocal.data.services.local.dto.UserPojo

@Dao
interface UserDao {

    @Query("SELECT * FROM user WHERE currentUser = 1")
    fun getCurrentUser(): List<UserPojo>

    @Insert
    fun insertUser(accessPojo: UserPojo)

    @Update
    fun updateUser(accessPojo: UserPojo)

    @Query("DELETE FROM user;")
    fun deleteUsers()
}