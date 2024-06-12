package com.example.myapplication.helper

sealed class NavigationItems(val route: String) {
    data object Splash : NavigationItems(ScreenType.SPLASH.name)

    data object Welcome : NavigationItems(ScreenType.WELCOME.name)
    data object Login : NavigationItems(ScreenType.LOGIN.name)
    data object SignUp : NavigationItems(ScreenType.SIGNUP.name)
    data object OTP : NavigationItems(ScreenType.OTP.name)
    data object INFO : NavigationItems(ScreenType.INFO.name)
    data object HOME : NavigationItems(ScreenType.HOME.name)


}