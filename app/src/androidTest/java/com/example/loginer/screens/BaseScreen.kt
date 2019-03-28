package com.example.loginer.screens

import android.support.test.InstrumentationRegistry
import android.support.test.uiautomator.BySelector
import android.support.test.uiautomator.UiDevice
import android.support.test.uiautomator.UiObject2

abstract class BaseScreen(private val device: UiDevice) {
    val packageName = InstrumentationRegistry.getTargetContext().packageName
    fun find(by: BySelector): UiObject2 = device.findObject(by)
    fun click(by: BySelector) = find(by).click()
}