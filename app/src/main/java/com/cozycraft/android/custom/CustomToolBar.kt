package com.cozycraft.android.custom

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.cozycraft.android.theme.navTitleColor
import com.cozycraft.android.theme.navbgColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomToolBar(modifier: Modifier = Modifier,navHostController: NavHostController,title:String) {
    TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = navbgColor,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(text = title, color = navTitleColor)
                },
                navigationIcon = {
                    IconButton(onClick = { navHostController.popBackStack()}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
            )
}

