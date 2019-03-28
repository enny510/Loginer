package com.example.loginer

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.support.test.uiautomator.By
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.Until

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import android.content.Intent
import org.junit.Ignore

@RunWith(AndroidJUnit4::class)
@Ignore
open class BaseTest {
    lateinit var device: UiDevice


    companion object {
        const val LAUNCH_TIMEOUT = 10000L
        const val PACKAGE_NAME = "com.example.loginer"
    }

    @Before
    fun setUp() {
        device = startDevice()
    }

    private fun startDevice(): UiDevice {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        val packageName = InstrumentationRegistry.getTargetContext().packageName
        val context = InstrumentationRegistry.getContext()
        val intent = context.packageManager
                .getLaunchIntentForPackage(PACKAGE_NAME)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

        context.startActivity(intent)
        device.wait(Until.hasObject(By.pkg(PACKAGE_NAME).depth(0)), LAUNCH_TIMEOUT)
        return device
    }
}

