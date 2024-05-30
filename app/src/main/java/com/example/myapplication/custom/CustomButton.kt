package com.example.myapplication.custom

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.ui.theme.Typography

@Composable
fun CustomButton(text: String, modifier: Modifier, navHostController: NavHostController,route:String) {
    val context = LocalContext.current
    FilledTonalButton(modifier = modifier, colors =
    ButtonDefaults.filledTonalButtonColors(
        containerColor = colorResource(id = R.color.black),
        contentColor = colorResource(id = R.color.white)
    ),
        onClick = {
            navHostController.navigate(route = route)
        }) {
        Text(
            text = text,
            style = Typography.titleLarge,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.white),
            fontSize = 18.sp
        )
    }
}
