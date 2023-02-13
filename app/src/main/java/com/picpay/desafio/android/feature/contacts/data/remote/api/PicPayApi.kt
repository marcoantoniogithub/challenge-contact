package com.picpay.desafio.android.feature.contacts.data.remote.api

import com.picpay.desafio.android.feature.contacts.data.remote.dto.UserDTO
import retrofit2.http.GET

interface PicPayApi {

    @GET("users")
    suspend fun getUsers(): List<UserDTO>
}