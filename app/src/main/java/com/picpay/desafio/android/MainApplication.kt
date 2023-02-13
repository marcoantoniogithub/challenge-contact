package com.picpay.desafio.android

import android.app.Application
import com.picpay.desafio.android.core.di.CoreModule
import com.picpay.desafio.android.feature.contacts.di.ContactsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    CoreModule.instance,
                    ContactsModule.instance
                )
            )
        }
    }
}