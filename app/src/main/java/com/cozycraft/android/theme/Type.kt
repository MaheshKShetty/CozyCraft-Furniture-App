package com.cozycraft.android.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.cozycraft.android.R

// Set of Material typography styles to start with
val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_bold)),
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_light)),
        fontWeight = FontWeight.Normal,
        letterSpacing = 0.sp,
        fontSize = 16.sp,
        color = titleColor
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
    )
)