package com.theapache64.composeandroidtemplate.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.theapache64.composeandroidtemplate.ui.screen.dashboard.DashboardScreen
import com.theapache64.composeandroidtemplate.ui.screen.splash.SplashScreen
import com.theapache64.composeandroidtemplate.ui.theme.ComposeAndroidTemplateTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ComposeAndroidTemplateTheme {
                Surface {
                    NavHost(navController = navController, startDestination = Screen.Splash.route) {

                        // Splash
                        composable(Screen.Splash.route) {
                            SplashScreen(
                                onSplashFinished = {
                                    val options = NavOptions.Builder()
                                        .setPopUpTo(Screen.Splash.route, inclusive = true)
                                        .build()
                                    navController.navigate(
                                        Screen.Dashboard.route,
                                        options
                                    ) // Move to dashboard
                                }
                            )
                        }

                        // Dashboard
                        composable(Screen.Dashboard.route) {
                            DashboardScreen()
                        }
                    }
                }
            }
        }
    }
}
