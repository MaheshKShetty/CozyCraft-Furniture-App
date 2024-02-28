package com.cap.myapplication.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.cap.myapplication.R
import com.cap.myapplication.ui.theme.textColor

@Composable
fun SignUpScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    val context = LocalContext.current
    Column(modifier = modifier.fillMaxSize()) {
        Row(
            Modifier
                .fillMaxWidth()
                .weight(0.4f)
                .background(color = LightGray)) {
            Text(text = context.getString(R.string.signUp),
                modifier = Modifier.padding(vertical = 45.dp, horizontal = 8.dp),
                fontSize = 18.sp,
                color = Blue,
                textAlign = TextAlign.Start)
        }

        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(color = White, shape = RoundedCornerShape(8.dp)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {

        }

    }

}