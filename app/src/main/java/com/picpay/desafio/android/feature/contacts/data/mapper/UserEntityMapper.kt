package com.picpay.desafio.android.feature.contacts.data.mapper

import com.picpay.desafio.android.feature.contacts.data.local.entity.UserEntity
import com.picpay.desafio.android.feature.contacts.domain.model.User

fun UserEntity.toUser() = User(
    id = id,
    img = img,
    name = name,
    username = username
)

fun List<UserEntity>.toUser(): List<User> =
    this.map {
        it.toUser()
    }
