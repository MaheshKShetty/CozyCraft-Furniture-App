package com.cozycraft.android.navigation.dashboard

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String) {
    data object Home : BottomNavItem(route = BottomNavConstant.Companion.HOME)
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
                route = BottomNavConstant.Companion.HOME
            ),
            BottomNavigationItem(
                label = "Profile",
                icon = Icons.Filled.AccountCircle,
                route = BottomNavConstant.Companion.PROFILE
            ),
        )
    }
}