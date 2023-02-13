package com.picpay.desafio.android.feature.contacts.domain.repository

import com.picpay.desafio.android.feature.contacts.domain.model.User

interface PicPayRepository {

    suspend fun getUsers(): List<User>
}