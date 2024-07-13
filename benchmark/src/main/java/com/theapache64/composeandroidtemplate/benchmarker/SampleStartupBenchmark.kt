package com.theapache64.composeandroidtemplate.benchmarker

import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class SampleStartupBenchmark {
    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @Test
    fun startup() = benchmarkRule.measureRepeated(
        packageName = "com.theapache64.composeandroidtemplate",
        metrics = listOf(StartupTimingMetric()),
        iterations = 3,
        setupBlock = {
            // Press home button before each run to ensure the starting activity isn't visible.
            pressHome()
        }
    ) {
        // starts default launch activity
        startActivityAndWait()

        // Check if composable TAG_DASHBOARD is visible
        val dashboardScreen = By.res("DashboardScreen")
        val isFound = device.wait(Until.hasObject(dashboardScreen), 5000)
        if (!isFound) {
            throw AssertionError("DashboardScreen not found")
        }
    }
}
