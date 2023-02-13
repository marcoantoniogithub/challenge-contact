package com.picpay.desafio.android.core.dataSource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.picpay.desafio.android.feature.contacts.data.local.dao.UserDao
import com.picpay.desafio.android.feature.contacts.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}