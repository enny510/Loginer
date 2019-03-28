package com.example.loginer.screens

import android.support.test.uiautomator.By
import android.support.test.uiautomator.UiDevice

class LoginScreen(device: UiDevice): BaseScreen(device) {
    private val loginField = By.res("$packageName:id/login_input")
    private val passwordField = By.res("$packageName:id/password_input")

    companion object {
        val screenMarker = By.text("Log in")
    }

    fun setLogin(login: String): LoginScreen{
        find(loginField).text = login
        return this
    }

    fun setPassword(password: String): LoginScreen{
        find(passwordField).text = password
        return this
    }

}