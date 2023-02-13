package com.picpay.desafio.android.feature.contacts.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.picpay.desafio.android.feature.contacts.data.local.entity.UserEntity


@Dao
interface UserDao {
    @Query("SELECT * FROM user order by id ASC")
    suspend fun getAll(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies: List<UserEntity>)

    @Query("DELETE FROM user")
    suspend fun deleteAll()
}