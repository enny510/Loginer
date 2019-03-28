package com.example.loginer.config

import com.example.loginer.config.modules.AppModule
import com.example.loginer.ui.activities.LoginActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun injects(loginActivity: LoginActivity)
}
