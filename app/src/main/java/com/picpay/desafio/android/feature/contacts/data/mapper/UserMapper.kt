package com.picpay.desafio.android.feature.contacts.data.mapper

import com.picpay.desafio.android.feature.contacts.data.local.entity.UserEntity
import com.picpay.desafio.android.feature.contacts.domain.model.User

fun User.toUserEntity() = UserEntity(
    id = id,
    img = img,
    name = name,
    username = username
)

fun List<User>.toUserEntity(): List<UserEntity> =
    this.map {
        it.toUserEntity()
    }