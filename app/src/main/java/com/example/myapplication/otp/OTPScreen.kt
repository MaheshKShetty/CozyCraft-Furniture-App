package com.example.myapplication.otp

import android.text.TextUtils
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.custom.CustomButton
import com.example.myapplication.custom.CustomOtpTextField
import com.example.myapplication.custom.CustomTextField
import com.example.myapplication.custom.CustomToolBar
import com.example.myapplication.helper.NavigationItems
import com.example.myapplication.ui.theme.OtpTextFieldTheme
import com.example.myapplication.ui.theme.Typography
import com.example.myapplication.ui.theme.titleColor

@Composable
fun OTPScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }
    val modifierPadding = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
    var otpValue by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    Column(modifier = modifier.fillMaxSize()) {
        Scaffold(
            topBar = {
                CustomToolBar(
                    navHostController = navHostController,
                    modifier = modifier,
                    title = "OTP"
                )
            }
        ) { innerPadding ->
            Column(modifier = modifier.fillMaxSize().padding(innerPadding), verticalArrangement = Arrangement.Top) {
                Text(
                    text = context.getString(R.string.otp_desc),
                    modifier = Modifier.padding(16.dp,16.dp,16.dp,56.dp),
                    style = Typography.bodyMedium,
                    textAlign = TextAlign.Start,
                    color = titleColor
                )

                OtpTextFieldTheme {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(20.dp),
                        color = Color.White,
                    ) {

                        CustomOtpTextField(
                            otpText = otpValue,
                            onOtpTextChange = { value, otpInputFilled ->
                                otpValue = value
                            }
                        )
                    }
                }

                CustomButton(
                    text = context.resources.getString(R.string.submit),
                    onClick = {
                        if (TextUtils.isEmpty(otpValue)) {

                        } else {
                            navHostController.navigate(NavigationItems.INFO.route)
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