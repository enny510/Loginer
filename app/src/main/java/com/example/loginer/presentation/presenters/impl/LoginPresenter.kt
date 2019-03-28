package com.example.loginer.presentation.presenters.impl

import com.example.loginer.model.UserRepository
import com.example.loginer.model.UserRepositoryImpl
import com.example.loginer.presentation.contracts.LoginContract
import com.example.loginer.presentation.presenters.BasePresenter

class LoginPresenter(
        private val userRepository: UserRepository
): BasePresenter<LoginContract.View>(), LoginContract.Presenter {
    override fun onDataGot(login: String, password: String) {
        userRepository.findByLoginAndPassword(login, password)?.let { view?.onSuccess() }
    }
}