package com.example.myapplication.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.custom.CustomToolBar
import com.example.myapplication.ui.theme.Typography
import com.example.myapplication.ui.theme.titleColor

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }

    val context = LocalContext.current
    Column(modifier = modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                CustomToolBar(
                    navHostController = navHostController,
                    modifier = modifier,
                    title = "Home"
                )
            }
        ) { innerPadding ->
            Column(modifier = modifier.fillMaxSize().padding(innerPadding), verticalArrangement = Arrangement.Center) {

                Image(
                    painter = painterResource(id = R.drawable.ic_info),
                    contentDescription = "App Logo",
                    modifier = Modifier.width(200.dp).align(Alignment.CenterHorizontally).height(200.dp)
                )

                Text(
                    text = context.getString(R.string.home_desc),
                    modifier = Modifier.padding(16.dp,16.dp,16.dp,16.dp).align(Alignment.CenterHorizontally),
                    style = Typography.bodyMedium,
                    textAlign = TextAlign.Start,
                    color = titleColor,
                )
            }

        }
    }
}