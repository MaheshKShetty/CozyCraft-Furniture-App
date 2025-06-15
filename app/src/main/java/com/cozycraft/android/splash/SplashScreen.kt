package com.cozycraft.android.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.navigation.NavHostController
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.cozycraft.android.navigation.login.NavigationItems
import com.cozycraft.android.preferences.PrefConstant
import com.cozycraft.android.preferences.PrefHelper
import com.cozycraft.android.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        delay(4000)
        if (PrefHelper.Companion.getInstance(context)?.getBoolean(PrefConstant.IS_LOGGED_IN) == true) {
            navController.navigate(NavigationItems.HOME.route)
        } else {
            navController.navigate(NavigationItems.Welcome.route)
        }
    }

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
}