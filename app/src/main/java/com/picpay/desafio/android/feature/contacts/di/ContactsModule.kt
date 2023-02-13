package com.picpay.desafio.android.feature.contacts.di

import com.picpay.desafio.android.core.dataSource.database.AppDatabase
import com.picpay.desafio.android.feature.contacts.data.PicPayRepositoryImpl
import com.picpay.desafio.android.feature.contacts.data.local.PicPayDataSourceLocal
import com.picpay.desafio.android.feature.contacts.data.local.dao.UserDao
import com.picpay.desafio.android.feature.contacts.data.remote.PicPayDataSourceRemote
import com.picpay.desafio.android.feature.contacts.data.remote.api.PicPayApi
import com.picpay.desafio.android.feature.contacts.domain.repository.PicPayRepository
import com.picpay.desafio.android.feature.contacts.domain.usecase.PicPayUseCase
import com.picpay.desafio.android.feature.contacts.presentation.UserListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

object ContactsModule {

    val instance = module {
        viewModel { UserListViewModel(get()) }
        single<PicPayUseCase> { PicPayUseCase(get()) }
        single<PicPayDataSourceRemote> { PicPayDataSourceRemote(get()) }
        single<PicPayDataSourceLocal> { PicPayDataSourceLocal(get()) }
        single<PicPayRepository> { PicPayRepositoryImpl(get(), get()) }
        single<PicPayApi> { providePicPayApi(get()) }
        factory<UserDao> { provideDao(get()) }
    }

    fun providePicPayApi(retrofit: Retrofit): PicPayApi = retrofit.create(PicPayApi::class.java)

    fun provideDao(dataBase: AppDatabase): UserDao {
        return dataBase.userDao()
    }
}