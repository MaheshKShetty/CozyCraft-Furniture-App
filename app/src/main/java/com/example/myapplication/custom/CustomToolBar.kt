package com.example.myapplication.custom

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.myapplication.ui.theme.navTitleColor
import com.example.myapplication.ui.theme.navbgColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomToolBar(modifier: Modifier = Modifier,navHostController: NavHostController,title:String) {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = navbgColor,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(title, color = navTitleColor)
                },
                navigationIcon = {
                    IconButton(onClick = { navHostController.popBackStack()}) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
            )
}

