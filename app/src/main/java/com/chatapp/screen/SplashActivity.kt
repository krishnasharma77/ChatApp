package com.chatapp.screen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.chatapp.viewmodel.SplashViewModel
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private var hasNavigated = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            SplashContent()
        }

        Handler(Looper.getMainLooper()).postDelayed({
            if (!hasNavigated) {
                navigateToMainActivity()
            }
        }, 3000)
    }

    @Composable
    fun SplashContent() {
        // Call the function to install the splash screen
        installSplashScreen()
    }

    private fun navigateToMainActivity() {
        hasNavigated = true
        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
/*
class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "splashRoute"
            ) {
                composable("splashRoute") {
                    SplashContent(navController)
                }
                composable("mainActivityRoute") {
                }
            }
        }
    }


    @Composable
    fun SplashContent(navController: NavController) {
        // Call the function to install the splash screen
        installSplashScreen()

        // Use LaunchedEffect to launch code when the composable is first displayed
        LaunchedEffect(Unit) {
            // Delay for 3000 milliseconds (3 seconds)
            delay(3000)

            // Navigate to the main activity using Compose Navigation
            navController.navigate("mainActivityRoute")
        }
    }
}
*/
