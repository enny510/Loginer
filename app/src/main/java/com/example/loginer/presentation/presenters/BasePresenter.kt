package com.example.loginer.presentation.presenters

import com.example.loginer.presentation.views.IView

abstract class BasePresenter<T : IView> : IPresenter<T> {

    var view: T? = null

    override fun attachView(view: T) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }
}