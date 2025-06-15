package com.cozycraft.android.webview

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.cozycraft.android.custom.CustomToolBar

@Composable
fun WebView(modifier: Modifier, navHostController: NavHostController) {
    Column(modifier = modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                CustomToolBar(
                    navHostController = navHostController,
                    modifier = modifier,
                    title = ""
                )
            }
        ) { innerPadding ->
            AndroidView(factory = { context ->
                WebView(context).apply {
                    webViewClient = WebViewClient()
                    loadUrl("https://github.com/MaheshKShetty/CozyCraft-Furniture-App")
                }
            })
        }
    }

}