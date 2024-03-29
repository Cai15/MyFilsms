package com.example.myfilsms

import android.app.Application
import com.example.myfilsms.di.AppComponent
import com.example.myfilsms.di.DaggerAppComponent
import com.example.myfilsms.di.modules.DatabaseModule
import com.example.myfilsms.di.modules.DomainModule
import com.example.myfilsms.di.modules.RemoteModule

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        //Создаем компонент
        dagger = DaggerAppComponent.builder()
            .remoteModule(RemoteModule())
            .databaseModule(DatabaseModule())
            .domainModule(DomainModule(this))
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
    }
}