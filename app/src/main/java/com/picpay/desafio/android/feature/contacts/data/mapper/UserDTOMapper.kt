package com.picpay.desafio.android.feature.contacts.data.mapper

import com.picpay.desafio.android.feature.contacts.data.remote.dto.UserDTO
import com.picpay.desafio.android.feature.contacts.domain.model.User

fun UserDTO.toUser() = User(
    id = id,
    img = img,
    name = name,
    username = username
)

fun List<UserDTO>.toUser(): List<User> =
    this.map {
        it.toUser()
    }


