package com.cozycraft.android.custom

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.cozycraft.android.R
import com.cozycraft.android.theme.Typography

@Composable
fun CustomButton(
    text: String,
    modifier: Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true // Add enabled parameter with default value true
) {
    FilledTonalButton(
        modifier = modifier,
        colors = ButtonDefaults.filledTonalButtonColors(
            containerColor = colorResource(id = R.color.black),
            contentColor = colorResource(id = R.color.white),
            disabledContainerColor = if (enabled) colorResource(id = R.color.black) else Color.Gray, // Adjust disabled color
            disabledContentColor = if (enabled) colorResource(id = R.color.white) else Color.LightGray // Adjust disabled color
        ),
        onClick = onClick,
        enabled = enabled // Pass enabled state to FilledTonalButton
    ) {
        Text(
            text = text,
            style = Typography.titleLarge,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.white),
            fontSize = 18.sp
        )
    }
}

interface on
