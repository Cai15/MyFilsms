package com.example.remote_module


import androidx.test.platform.app.InstrumentationRegistry.*
import androidx.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation as getInstrumentation1

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = getInstrumentation1().targetContext
        assertEquals("com.example.remote_module.test", appContext.packageName)
    }
}