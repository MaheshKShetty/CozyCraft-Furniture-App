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

    fun isValidEmail(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
        return email.matches(emailPattern.toRegex())
    }

    fun isValidPassword(password: String): Boolean {
        val passwordPattern = """^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\S+$).{8,}$"""
        return password.matches(passwordPattern.toRegex())
    }

    fun validatePassword(password: String): String? {
        if (password.length < 8) {
            return "Password must be at least 8 characters long"
        }
        if (!password.any { it.isUpperCase() }) {
            return "Password must contain at least one uppercase letter"
        }
        if (!password.any { it.isLowerCase() }) {
            return "Password must contain at least one lowercase letter"
        }
        if (!password.any { it.isDigit() }) {
            return "Password must contain at least one digit"
        }
        if (!password.any { "!@#$%^&*()_+-=[]|,./?><".contains(it) }) {
            return "Password must contain at least one special character"
        }
        return null
    }

    fun isValidFirstName(firstName: String): String? {
        val firstNamePattern = "^[A-Z][a-zA-Z]{1,49}$"
        return if (firstName.matches(firstNamePattern.toRegex())) null
        else "First name must start with an uppercase letter and contain only alphabetic characters. It should be between 2 and 50 characters long."
    }
}