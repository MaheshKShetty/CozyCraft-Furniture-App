package com.example.myapplication.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.helper.NavigationItems
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.preferences.PrefConstant
import com.example.myapplication.preferences.PrefHelper
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    val context = LocalContext?.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        LaunchedEffect(Unit) {
            delay(1000)

            if (PrefHelper.getInstance(context)?.getBoolean(PrefConstant.IS_LOGGED_IN) == true) {
                navController.navigate(NavigationItems.HOME.route)
            } else {
                navController.navigate(NavigationItems.Welcome.route)
            }
        }
    }
}