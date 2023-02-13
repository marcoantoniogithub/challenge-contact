package com.picpay.desafio.android.feature.contacts.data.local

import com.picpay.desafio.android.feature.contacts.data.local.dao.UserDao
import com.picpay.desafio.android.feature.contacts.data.mapper.toUser
import com.picpay.desafio.android.feature.contacts.data.mapper.toUserEntity
import com.picpay.desafio.android.feature.contacts.domain.model.User

class PicPayDataSourceLocal(
    private val cache: UserDao
) {

    suspend fun getUsers(): List<User> {
        return cache.getAll().toUser()
    }

    suspend fun insertAll(list: List<User>) {
        return cache.insertAll(list.toUserEntity())
    }

    suspend fun deleteAll() {
        return cache.deleteAll()
    }
}