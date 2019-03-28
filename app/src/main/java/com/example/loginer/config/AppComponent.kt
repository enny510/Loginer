package com.example.loginer.config

import com.example.loginer.config.modules.AppModule
import com.example.loginer.ui.activities.LoginActivity
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun injects(mainActivity: LoginActivity)
}
