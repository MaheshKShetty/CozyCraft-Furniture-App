package com.example.myapplication.navigation.dashboard

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.myapplication.navigation.dashboard.BottomNavConstant.Companion.HOME
import com.example.myapplication.navigation.dashboard.BottomNavConstant.Companion.PROFILE
import com.example.myapplication.navigation.dashboard.BottomNavConstant.Companion.SEARCH

sealed class BottomNavItem(val route: String) {
    data object Home : BottomNavItem(route = HOME)
    data object SEARCH : BottomNavItem(route = BottomNavConstant.SEARCH)
    data object PROFILE : BottomNavItem(route = BottomNavConstant.PROFILE)
}

class BottomNavConstant {
    companion object {
    const val HOME = "home"
    const val SEARCH = "search"
    const val PROFILE = "profile"
    }
}

data class BottomNavigationItem(
    val label : String = "",
    val icon : ImageVector = Icons.Filled.Home,
    val route : String = ""
) {
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = "Home",
                icon = Icons.Filled.Home,
                route = HOME
            ),
            BottomNavigationItem(
                label = "Profile",
                icon = Icons.Filled.AccountCircle,
                route = PROFILE
            ),
        )
    }
}