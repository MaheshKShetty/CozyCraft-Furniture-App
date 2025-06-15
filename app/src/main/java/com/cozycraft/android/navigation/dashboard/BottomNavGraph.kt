package com.cozycraft.android.navigation.dashboard

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cozycraft.android.dashboard.HomeScreen
import com.cozycraft.android.dashboard.ProfileScreen

@Composable
fun BottomNavGraph(navHostController: NavHostController,modifier: Modifier) {
    NavHost(navController = navHostController, startDestination = BottomNavItem.Home.route) {
        composable(route = BottomNavItem.Home.route) {
            HomeScreen(modifier)
        }
        composable(route = BottomNavItem.PROFILE.route) {
            ProfileScreen(modifier)
        }
    }
}