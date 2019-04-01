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
        // when set valid login and then valid password
        LoginScreen(device).setLogin(VALID_LOGIN).setPassword(VALID_PASSWORD)
        // then current screen is success login screen
        device.wait(Until.findObject(SuccessLoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
    }

    @Test
    fun validPasswordLoginTest() {
        // when set valid password and then valid login
        LoginScreen(device).setPassword(VALID_PASSWORD).setLogin(VALID_LOGIN)
        // then current screen is success login screen
        device.wait(Until.findObject(SuccessLoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
    }

    @Test
    fun loginWithInvalidDataTest() {
        // when set invalid login and then invalid password
        LoginScreen(device).setLogin("t").setPassword("t")
        // then current screen still login screen
        device.wait(Until.findObject(LoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
    }

    @Test
    fun loginWithoutPasswordTest() {
        //when set valid login and stay password field empty
        LoginScreen(device).setLogin(VALID_LOGIN)
        // then current screen still login screen
        device.wait(Until.findObject(LoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
    }

    @Test
    fun loginWithoutLoginTest() {
        //when set valid password and stay password field empty
        LoginScreen(device).setPassword(VALID_PASSWORD)
        // then current screen still login screen
        device.wait(Until.findObject(LoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
    }

    @Test
    fun loginWithWrongLoginTest() {
        //when set invalid login and valid password
        LoginScreen(device).setLogin("t").setPassword(VALID_PASSWORD)
        // then current screen still login screen
        device.wait(Until.findObject(LoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
    }

    @Test
    fun loginWithWrongPasswordTest() {
        //when set valid login and invalid password
        LoginScreen(device).setLogin(VALID_LOGIN).setPassword("t")
        // then current screen still login screen
        device.wait(Until.findObject(LoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
    }

    @Test
    fun loginAsValidUserAndBackTest() {
        // when success log in and press back button on success login screen
        val successLoginScreen = LoginScreen(device).authorizeAsUser(User(VALID_LOGIN, VALID_PASSWORD))
        device.wait(Until.findObject(SuccessLoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
        successLoginScreen.clickBack()
        // then current screen is login screen
        device.wait(Until.findObject(LoginScreen.screenMarker), BaseTest.LAUNCH_TIMEOUT)
    }
}