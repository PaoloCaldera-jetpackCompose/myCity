package com.example.mycity

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.junit4.StateRestorationTester
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.mycity.ui.theme.MyCityTheme
import org.junit.Rule
import org.junit.Test

class AdaptiveLayoutTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun myCityApp_expandedSize_configurationChange() {
        // GIVEN: state restoration tester for expanded device
        val stateRestorationTester = StateRestorationTester(composeTestRule)
        stateRestorationTester.setContent { 
            MyCityTheme {
                MyCityApp(widthSizeClass = WindowWidthSizeClass.Expanded)
            }
        }
        composeTestRule
            .onNodeWithTag("TAG_NAVIGATION_DRAWER")
            .assertExists()

        // WHEN: configuration change, from landscape to portrait
        stateRestorationTester.emulateSavedInstanceStateRestore()

        // THEN: the navigation drawer still exists
        composeTestRule
            .onNodeWithTag("TAG_NAVIGATION_DRAWER")
            .assertExists()
    }
}