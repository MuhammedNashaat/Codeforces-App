package com.example.codeforcesapp

import android.app.Application
import com.example.codeforcesapp.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class CodeForcesApp: Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CodeForcesApp)
            androidLogger()

            modules(appModule)
        }
    }
}