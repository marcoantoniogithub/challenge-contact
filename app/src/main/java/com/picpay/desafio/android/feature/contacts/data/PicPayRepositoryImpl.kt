package com.picpay.desafio.android.feature.contacts.data

import com.picpay.desafio.android.feature.contacts.data.local.PicPayDataSourceLocal
import com.picpay.desafio.android.feature.contacts.data.remote.PicPayDataSourceRemote
import com.picpay.desafio.android.feature.contacts.domain.model.User
import com.picpay.desafio.android.feature.contacts.domain.repository.PicPayRepository

class PicPayRepositoryImpl(
    private val remote: PicPayDataSourceRemote,
    private val local: PicPayDataSourceLocal
): PicPayRepository {

    override suspend fun getUsers(): List<User> {
        try {
            val listLocal = local.getUsers()
            if(listLocal.size > 1) {
                return listLocal
            }
            val list = remote.getUsers()
            local.deleteAll()
            local.insertAll(list)
            return list
        } catch (e: Exception) {
            throw e
        }
    }
}