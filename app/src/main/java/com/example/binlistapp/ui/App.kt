package com.example.binlistapp.ui

import android.app.Application
import com.example.binlistapp.di.dataModule
import com.example.binlistapp.di.interactorModule
import com.example.binlistapp.di.repositoryModule
import com.example.binlistapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(dataModule, repositoryModule, interactorModule, viewModelModule)
        }
    }
}
