package com.example.loginer

import android.support.test.uiautomator.By
import android.support.test.uiautomator.UiObject2
import android.support.test.uiautomator.Until
import com.example.loginer.model.UserRepositoryImpl
import com.example.loginer.screens.LoginScreen
import com.example.loginer.screens.SuccessLoginScreen
import junit.framework.Assert.assertEquals
import org.junit.Test

class LoginPageTest: BaseTest() {

    @Test
    fun validLoginPasswordTest() {
        LoginScreen(device).setLogin("test").setPassword("test")
        device.wait(Until.findObject(SuccessLoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
    }

    @Test
    fun validPasswordLoginTest() {
        LoginScreen(device).setPassword("test").setLogin("test")
        device.wait(Until.findObject(SuccessLoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
    }

    @Test
    fun loginWithInvalidDataTest() {
        LoginScreen(device).setLogin("t").setPassword("t")
        device.wait(Until.findObject(LoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
    }

    @Test
    fun loginWithoutPasswordTest() {
        LoginScreen(device).setLogin("test")
        device.wait(Until.findObject(LoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
    }

    @Test
    fun loginWithoutLoginTest() {
        LoginScreen(device).setPassword("test")
        device.wait(Until.findObject(LoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
    }
}