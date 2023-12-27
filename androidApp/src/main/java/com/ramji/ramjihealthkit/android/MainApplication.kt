package com.ramji.ramjihealthkit.android

import android.app.Application
import com.ramji.ramjihealthkit.di.appModule
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(appModule())
        }
    }
}