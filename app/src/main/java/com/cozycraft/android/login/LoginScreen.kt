package com.cozycraft.android.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.cozycraft.android.preferences.PrefHelper
import com.cozycraft.android.navigation.login.NavigationItems
import com.cozycraft.android.preferences.PrefConstant.IS_LOGGED_IN
import com.cozycraft.android.signup.LoginViewModel
import com.cozycraft.android.theme.Typography
import com.cozycraft.android.theme.titleColor
import androidx.compose.runtime.livedata.observeAsState
import com.cozycraft.android.helper.Utils


@Composable
fun LoginScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }
    val modifierPadding = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)

    val context = LocalContext.current
    var emailError by remember { mutableStateOf(false) }
    var emailErrorMessage by remember { mutableStateOf<String?>(null) }
    var passwordError by remember { mutableStateOf(false) }
    var passwordErrorMessage by remember { mutableStateOf<String?>(null) }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val viewModel: LoginViewModel = viewModel()
    val user by viewModel.userLiveData.observeAsState()

    Column(modifier = modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                CustomToolBar(
                    navHostController = navHostController,
                    modifier = modifier,
                    title = "Login"
                )
            }
        ) { innerPadding ->
            Column(modifier = modifier.fillMaxSize().padding(innerPadding), verticalArrangement = Arrangement.Top) {
                Text(
                    text = context.getString(R.string.signup_desc),
                    modifier = Modifier.padding(16.dp, 16.dp, 16.dp, 36.dp),
                    style = Typography.bodyMedium,
                    textAlign = TextAlign.Start,
                    color = titleColor
                )

                CustomTextField(
                    modifier = modifierPadding,
                    label = "Enter your Email",
                    isError = emailError,
                    errorText = emailErrorMessage,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    onValueChange = {
                        email = it
                        emailError = false
                        emailErrorMessage = null
                    }
                )

                CustomTextField(
                    modifier = modifierPadding,
                    label = "Password",
                    isPassword = true,
                    isError = passwordError,
                    errorText = passwordErrorMessage,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    onValueChange = {
                        password = it
                        passwordError = false
                        passwordErrorMessage = null
                    }
                )

                CustomButton(
                    text = context.resources.getString(R.string.login),
                    onClick = {
                        if (!Utils.isValidEmail(email)) {
                            emailError = true
                            emailErrorMessage = context.resources.getString(R.string.email_error)
                        }
                        if (!Utils.isValidPassword(password)) {
                            passwordError = true
                            passwordErrorMessage = Utils.validatePassword(password)
                        }
                        if (!emailError && !passwordError) {
                            viewModel.getUserInfo(email)
                            if (user?.email == email) {
                                PrefHelper.Companion.getInstance(context)
                                    ?.putBoolean(IS_LOGGED_IN, true)
                                navHostController.navigate(NavigationItems.HOME.route)
                            }
                        }
                    },
                    modifier = modifierPadding
                        .fillMaxWidth()
                        .wrapContentHeight(),
                )
            }
        }
    }
}