package com.cozycraft.android.navigation.login

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cozycraft.android.dashboard.DashBoardActivity
import com.cozycraft.android.info.InfoScreen
import com.cozycraft.android.login.LoginScreen
import com.cozycraft.android.otp.OTPScreen
import com.cozycraft.android.signup.SignUpScreen
import com.cozycraft.android.splash.SplashScreen
import com.cozycraft.android.webview.WebView
import com.cozycraft.android.welcome.WelcomeScreen

@Composable
fun AppNavHost(
    modifier: Modifier, navController: NavHostController,
    startDestination: String = NavigationItems.Welcome.route,
) {

    NavHost(
        modifier = modifier,
        startDestination = startDestination, navController = navController
    ) {
        composable(route = NavigationItems.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(NavigationItems.Welcome.route) {
            WelcomeScreen(navHostController = navController)
        }
        composable(NavigationItems.Login.route) {
            LoginScreen(modifier = modifier,navHostController = navController)
        }
        composable(NavigationItems.SignUp.route) {
            SignUpScreen(modifier = modifier, navHostController = navController)
        }
        composable(NavigationItems.OTP.route) {
            OTPScreen(modifier = modifier, navHostController = navController)
        }
        composable(NavigationItems.INFO.route) {
            InfoScreen(modifier = modifier, navHostController = navController)
        }

        composable(NavigationItems.HOME.route) {
            val intent = Intent(LocalContext.current, DashBoardActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            LocalContext.current.startActivity(intent)
        }
        composable(NavigationItems.WEBVIEW.route) {
            WebView(modifier = modifier, navHostController = navController)
        }
    }
}