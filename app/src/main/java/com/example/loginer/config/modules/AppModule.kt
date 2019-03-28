package com.example.loginer.config.modules

import android.content.Context
import com.example.loginer.model.UserRepository
import com.example.loginer.model.UserRepositoryImpl
import com.example.loginer.presentation.contracts.LoginContract
import com.example.loginer.presentation.presenters.impl.LoginPresenter
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    internal fun provideLoginPresenter(repository: UserRepository): LoginContract.Presenter {
        return LoginPresenter(repository)
    }

    @Provides
    internal fun provideUserRepository(): UserRepository {
        return UserRepositoryImpl()
    }
}
