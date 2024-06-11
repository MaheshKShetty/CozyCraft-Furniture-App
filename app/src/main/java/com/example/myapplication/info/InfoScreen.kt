package com.example.myapplication.info

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.custom.CustomButton
import com.example.myapplication.custom.CustomTextField
import com.example.myapplication.custom.CustomToolBar
import com.example.myapplication.helper.NavigationItems
import com.example.myapplication.ui.theme.Typography
import com.example.myapplication.ui.theme.titleColor

@Composable
fun InfoScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }
    val modifierPadding = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)

    val context = LocalContext.current
    Column(modifier = modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                CustomToolBar(
                    navHostController = navHostController,
                    modifier = modifier,
                    title = "Login"
                )
            }
        ) { innerPadding ->
            Column(modifier = modifier.fillMaxSize().padding(innerPadding), verticalArrangement = Arrangement.Top) {
                Image(
                    painter = painterResource(id = R.drawable.ic_info),
                    contentDescription = "App Logo",
                    modifier = Modifier.width(200.dp).align(Alignment.CenterHorizontally).height(200.dp)
                )
                Text(
                    text = context.getString(R.string.account_created_desc),
                    modifier = Modifier.padding(16.dp,16.dp,16.dp,16.dp),
                    style = Typography.bodyMedium,
                    textAlign = TextAlign.Start,
                    color = titleColor
                )
                CustomButton(
                    text = context.resources.getString(R.string.login),
                    navHostController = navHostController,
                    modifier = modifierPadding
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    route = NavigationItems.Login.route,
                )
            }

        }
    }
}