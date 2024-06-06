package com.example.myapplication.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Image(
            painter = painterResource(id = R.mipmap.ic_launcher),
            contentDescription = "App Logo",
            modifier = Modifier.align(Alignment.Center).width(200.dp).height(200.dp)
        )
        LaunchedEffect(Unit) {
            delay(3000) // Delay for 3 second
            navController.navigate(NavigationItems.Welcome.route)
        }
    }
}