package com.colagom.lottery.android

import android.app.Application
import com.colagom.lottery.android.di.appModule
import com.colagom.lottery.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@App)
            androidLogger(Level.DEBUG)
            modules(appModule)
        }
    }
}