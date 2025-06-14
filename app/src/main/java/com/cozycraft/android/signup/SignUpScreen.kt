package com.cozycraft.android.signup

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.cozycraft.android.R
import com.cozycraft.android.custom.CustomButton
import com.cozycraft.android.custom.CustomTextField
import com.cozycraft.android.custom.CustomToolBar
import com.cozycraft.android.data.User
import com.cozycraft.android.helper.Utils
import com.cozycraft.android.navigation.login.NavigationItems
import com.cozycraft.android.theme.Typography
import com.cozycraft.android.theme.titleColor

@Composable
fun SignUpScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {

    val state = rememberScrollState()

    val modifierPadding = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
    var fullNameError by remember { mutableStateOf(false) }
    var fullNameErrorMessage by remember { mutableStateOf<String?>(null) }
    var fullName by remember { mutableStateOf<String?>(null) }

    var emailError by remember { mutableStateOf(false) }
    var emailErrorMessage by remember { mutableStateOf<String?>(null) }
    var email by remember { mutableStateOf<String?>(null) }

    var passwordError by remember { mutableStateOf(false) }
    var passwordErrorMessage by remember { mutableStateOf<String?>(null) }
    var password by remember { mutableStateOf<String?>(null) }

    var confirmPasswordError by remember { mutableStateOf(false) }
    var confirmPasswordErrorMessage by remember { mutableStateOf<String?>(null) }
    var confirmPassword by remember { mutableStateOf<String?>(null) }
    val viewModel: LoginViewModel = viewModel()
    val errorMessge by viewModel.errorMessage.collectAsState()
    val signupSuccess by viewModel.signupSuccess.collectAsState()

    LaunchedEffect(Unit) { state.animateScrollTo(100) }

    LaunchedEffect(signupSuccess) {
        if (signupSuccess) {
            navHostController.navigate(NavigationItems.HOME.route)
        }
    }

    val context = LocalContext.current
    Column(modifier = modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                CustomToolBar(
                    navHostController = navHostController,
                    modifier = modifier,
                    title = "Signup"
                )
            }
        ) { innerPadding ->
            Column(modifier = modifier.fillMaxSize().padding(innerPadding), verticalArrangement = Arrangement.Top) {
                Text(
                    text = context.getString(R.string.signup_desc),
                    modifier = Modifier.padding(16.dp,16.dp,16.dp,36.dp),
                    style = Typography.bodyMedium,
                    textAlign = TextAlign.Start,
                    color = titleColor
                )
                CustomTextField(
                    modifier = modifierPadding,
                    label = "Full Name ",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    isError = fullNameError,
                    errorText = fullNameErrorMessage,
                    onValueChange = {
                        fullNameError = false
                        fullNameErrorMessage = null
                        fullName = it
                    }
                )

                CustomTextField(
                    modifier = modifierPadding,
                    label = "Enter your Email",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    isError = emailError,
                    errorText = emailErrorMessage,
                    onValueChange = {
                        emailError = false
                        emailErrorMessage = null
                        email = it
                    }
                )

                CustomTextField(
                    modifier = modifierPadding,
                    label = "Password",
                    isPassword = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    isError = passwordError,
                    errorText = passwordErrorMessage,
                    onValueChange = {
                        passwordError = false
                        passwordErrorMessage = null
                        password = it
                    }
                )

                CustomTextField(
                    modifier = modifierPadding,
                    label = "Confirm Password",
                    isPassword = true,
                    isError = confirmPasswordError,
                    errorText = confirmPasswordErrorMessage,
                    onValueChange = {
                        confirmPasswordError = false
                        confirmPasswordErrorMessage = null
                        confirmPassword = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                )

                ClickableText(text = Utils.annotatedString,
                    style = MaterialTheme.typography.bodyMedium.copy(textAlign = TextAlign.Center),
                    modifier = modifierPadding,
                    onClick = { offset ->
                    Utils.annotatedString.getStringAnnotations(tag = "policy", start = offset, end = offset).firstOrNull()?.let {
                        navHostController.navigate(NavigationItems.WEBVIEW.route)
                    }

                    Utils.annotatedString.getStringAnnotations(tag = "terms", start = offset, end = offset).firstOrNull()?.let {
                        Log.d("terms URL", it.item)
                        navHostController.navigate(NavigationItems.WEBVIEW.route)
                    }
                })

                CustomButton(
                    text = context.resources.getString(R.string.login),
                    onClick = {
                        if (Utils.isValidFirstName(fullName ?: "") != null || fullName == "") {
                            fullNameError = true
                            fullNameErrorMessage = Utils.isValidFirstName(fullName ?: "")
                        }
                        if (!Utils.isValidEmail(email ?: "")) {
                            emailError = true
                            emailErrorMessage = context.resources.getString(R.string.email_error)
                        }
                        if (!Utils.isValidPassword(password ?: "")) {
                            passwordError = true
                            passwordErrorMessage = Utils.validatePassword(password ?: "")
                        }
                        if (password != confirmPassword) {
                            confirmPasswordError = true
                            confirmPasswordErrorMessage =
                                context.resources.getString(R.string.confirm_password_error)
                        }
                        if (!fullNameError && !emailError && !passwordError && !confirmPasswordError) {
                            var user = User(
                                firstName = fullName.toString(),
                                middleName = fullName.toString(),
                                LastName = fullName.toString(),
                                password = password.toString(),
                                dob = "",
                                address = "",
                                email = email.toString()
                            )
                            viewModel.storeUserData(user)
                        }
                    },
                    modifier = modifierPadding
                        .fillMaxWidth()
                        .wrapContentHeight(),
                )

                ClickableText(text = Utils.annotatedStringSignUp,
                    style = MaterialTheme.typography.bodyMedium.copy(textAlign = TextAlign.Center),
                    modifier = modifierPadding.align(Alignment.CenterHorizontally),
                    onClick = { offset ->
                        Utils.annotatedStringSignUp.getStringAnnotations(tag = "Login", start = offset, end = offset).firstOrNull()?.let {
                           navHostController.navigate(NavigationItems.Login.route)
                        }
                    })
            }
        }
    }

}