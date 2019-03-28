package com.example.loginer

import android.app.Application

import com.example.loginer.config.AppComponent
import com.example.loginer.config.modules.AppModule

class AndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder().appModule(AppModule())
                .build()
    }

    companion object {

        var component: AppComponent? = null
            private set
    }
}
