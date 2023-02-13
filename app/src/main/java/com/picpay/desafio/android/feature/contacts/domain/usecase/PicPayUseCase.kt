package com.picpay.desafio.android.feature.contacts.domain.usecase

import com.picpay.desafio.android.feature.contacts.domain.model.User
import com.picpay.desafio.android.feature.contacts.domain.repository.PicPayRepository

class PicPayUseCase(
    private val repository: PicPayRepository
) {

    suspend fun getUsers(): List<User> = repository.getUsers()
}