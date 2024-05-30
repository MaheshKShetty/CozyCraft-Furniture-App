package com.example.myapplication.helper

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.login.LoginScreen
import com.example.myapplication.signup.SignUpScreen
import com.example.myapplication.welcome.WelcomeScreen

@Composable
fun AppNavHost(
    modifier: Modifier, navController: NavHostController,
    startDestination: String = NavigationItems.Welcome.route,
) {

    NavHost(
        modifier = modifier,
        startDestination = startDestination, navController = navController
    ) {
        composable(NavigationItems.Welcome.route) {
            WelcomeScreen(navHostController = navController)
        }
        composable(NavigationItems.Login.route) {
            LoginScreen(modifier = modifier,navHostController = navController)
        }
        composable(NavigationItems.SignUp.route) {
            SignUpScreen(modifier = modifier,navHostController = navController)
        }
    }
}