package com.example.myapplication.helper

sealed class NavigationItems(val route: String) {
    data object Welcome : NavigationItems(ScreenType.WELCOME.name)
    data object Login : NavigationItems(ScreenType.LOGIN.name)
    data object SignUp : NavigationItems(ScreenType.SIGNUP.name)
}