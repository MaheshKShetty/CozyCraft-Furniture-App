package com.cozycraft.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.cozycraft.android.navigation.login.AppNavHost
import com.cozycraft.android.navigation.login.NavigationItems
import com.cozycraft.android.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavHost(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        startDestination = NavigationItems.Splash.route,
                        navController = rememberNavController()
                    )
                }
            }
        }
    }
    
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
    }
}

@Composable
fun SetStatusBarColor(color: Color) {
    SystemBarStyle.auto(android.graphics.Color.TRANSPARENT, android.graphics.Color.TRANSPARENT)
}
