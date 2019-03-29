package com.example.loginer

import android.support.test.uiautomator.By
import android.support.test.uiautomator.UiObject2
import android.support.test.uiautomator.Until
import com.example.loginer.model.User
import com.example.loginer.model.UserRepositoryImpl
import com.example.loginer.screens.LoginScreen
import com.example.loginer.screens.SuccessLoginScreen
import junit.framework.Assert.assertEquals
import org.junit.Test

class LoginTaskTest: BaseTest() {

    companion object {
        private const val VALID_LOGIN = "test"
        private const val VALID_PASSWORD = "test"
    }

    @Test
    fun validLoginPasswordTest() {
        LoginScreen(device).setLogin(VALID_LOGIN).setPassword(VALID_PASSWORD)
        device.wait(Until.findObject(SuccessLoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
    }

    @Test
    fun validPasswordLoginTest() {
        LoginScreen(device).setPassword(VALID_PASSWORD).setLogin(VALID_LOGIN)
        device.wait(Until.findObject(SuccessLoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
    }

    @Test
    fun loginWithInvalidDataTest() {
        LoginScreen(device).setLogin("t").setPassword("t")
        device.wait(Until.findObject(SuccessLoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
    }

    @Test
    fun loginWithoutPasswordTest() {
        LoginScreen(device).setLogin(VALID_LOGIN)
        device.wait(Until.findObject(LoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
    }

    @Test
    fun loginWithoutLoginTest() {
        LoginScreen(device).setPassword(VALID_PASSWORD)
        device.wait(Until.findObject(LoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
    }

    @Test
    fun loginWithWrongLoginTest() {
        LoginScreen(device).setLogin("t").setPassword(VALID_PASSWORD)
        device.wait(Until.findObject(LoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
    }

    @Test
    fun loginWithWrongPasswordTest() {
        LoginScreen(device).setLogin(VALID_LOGIN).setPassword("t")
        device.wait(Until.findObject(LoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
    }

    @Test
    fun loginAsValidUserAndBackTest() {
        val successLoginScreen = LoginScreen(device).authorizeAsUser(User(VALID_LOGIN, VALID_PASSWORD))
        device.wait(Until.findObject(SuccessLoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
        successLoginScreen.clickBack()
        device.wait(Until.findObject(LoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
    }
}