package com.picpay.desafio.android.feature.contacts.data.remote

import com.picpay.desafio.android.feature.contacts.data.mapper.toUser
import com.picpay.desafio.android.feature.contacts.data.remote.api.PicPayApi
import com.picpay.desafio.android.feature.contacts.domain.model.User

class PicPayDataSourceRemote(
    private val api: PicPayApi
) {

    suspend fun getUsers(): List<User> {
        return try {
            api.getUsers().toUser()
        } catch (e: Exception) {
            throw Exception(e)
        }
    }
}