package com.example.myapplication.helper

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle

object Utils {
    val annotatedString = buildAnnotatedString {
        append("By joining, you agree to the ")
        pushStringAnnotation(tag = "policy", annotation = "https://google.com/policy")
        withStyle(style = SpanStyle(color = Color.Blue)) {
            append("privacy policy")
        }
        pop()
        append(" and ")
        pushStringAnnotation(tag = "terms", annotation = "https://google.com/terms")
        withStyle(style = SpanStyle(color = Color.Blue)) {
            append("terms of use")
        }
        pop()
    }

    val annotatedStringSignUp = buildAnnotatedString {
        append("Have an account ?")
        pushStringAnnotation(tag = "Login", annotation = "https://google.com/policy")
        withStyle(style = SpanStyle(color = Color.Blue)) {
            append("Login")
        }
        pop()
    }
}