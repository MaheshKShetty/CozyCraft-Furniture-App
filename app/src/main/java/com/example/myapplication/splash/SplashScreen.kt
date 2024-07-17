package com.example.myapplication.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.R
import com.example.myapplication.animation.ComposeLottieScreen
import com.example.myapplication.navigation.login.NavigationItems
import com.example.myapplication.preferences.PrefConstant
import com.example.myapplication.preferences.PrefHelper
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally, // Center horizontally
        verticalArrangement = Arrangement.Center // Center vertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_splash),
            contentDescription = "Profile Icon",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )
    }
    LaunchedEffect(Unit) {
        delay(4000)
        if (PrefHelper.getInstance(context)?.getBoolean(PrefConstant.IS_LOGGED_IN) == true) {
            navController.navigate(NavigationItems.HOME.route)
        } else {
            navController.navigate(NavigationItems.Welcome.route)
        }
    }
}