package com.example.loginer.screens

import android.support.test.uiautomator.By
import android.support.test.uiautomator.UiDevice

class SuccessLoginScreen(device: UiDevice): BaseScreen(device) {

    private val backButton = By.res("$packageName:id/back_button")

    companion object {
        val screenMarker = By.text("Success Login")
    }
}