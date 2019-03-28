package com.example.loginer.presentation.contracts

import com.example.loginer.presentation.presenters.IPresenter
import com.example.loginer.presentation.views.IView



interface LoginContract {
    interface View : IView {
        fun onSuccess()
    }

    interface Presenter : IPresenter<View> {
        fun onDataGot(login: String, password: String)
    }

}