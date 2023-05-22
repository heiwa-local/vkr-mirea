package com.heiwalocal.data.services.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.heiwalocal.data.services.local.dao.UserDao
import com.heiwalocal.data.services.local.dto.UserPojo

@Database(entities = [UserPojo::class], version = 6)
abstract class LocalDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object{
        fun create(context: Context): LocalDatabase {
            return Room.databaseBuilder(
                context,
                LocalDatabase::class.java, "local"
            ).fallbackToDestructiveMigration().build()
        }
    }
}