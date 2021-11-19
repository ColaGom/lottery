package com.colagom.lottery.android

import android.app.Application
import com.colagom.lottery.di.initKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}