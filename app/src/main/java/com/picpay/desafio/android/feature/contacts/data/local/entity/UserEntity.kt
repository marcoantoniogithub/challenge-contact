package com.picpay.desafio.android.feature.contacts.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    val img: String,
    val name: String,
    @PrimaryKey val id: Int,
    val username: String
)