package com.picpay.desafio.android.core.di

import android.content.Context
import androidx.room.Room
import com.picpay.desafio.android.core.dataSource.database.AppDatabase
import com.picpay.desafio.android.core.dataSource.network.NetworkConfig
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit

object CoreModule {
    val instance = module {
        single<OkHttpClient>{NetworkConfig.providesOkHttpClient()}
        single<Retrofit> { NetworkConfig.provideRetrofit(get()) }
        single<AppDatabase> { provideDataBase(androidContext()) }
    }

    fun provideDataBase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "app_database").build()
    }
}
