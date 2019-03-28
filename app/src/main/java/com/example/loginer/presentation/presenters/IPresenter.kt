package com.example.loginer.presentation.presenters

import com.example.loginer.presentation.views.IView

interface IPresenter<V : IView> {
    fun attachView(view: V)
    fun detachView()
}