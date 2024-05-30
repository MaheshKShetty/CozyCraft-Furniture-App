package com.example.myapplication.welcome

import android.content.Context
import android.os.Build.VERSION.SDK_INT
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.myapplication.R
import com.example.myapplication.helper.NavigationItems

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {

    val context = LocalContext.current

    Column(
        Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Card {
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Image(
                    modifier = Modifier
                        .fillMaxSize(),
                    painter = rememberAsyncImagePainter("https://i.postimg.cc/Nfz2X9dn/furniture-1840463-1920.jpg"),
                    contentDescription = stringResource(id = R.string.app_name),
                    contentScale = ContentScale.FillHeight,
                )

                // Add the alpha overlay
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(color = Color.White.copy(alpha = 0.22f)) // Adjust alpha for desired transparency
                )

                Column(
                    Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = context.resources.getStringArray(R.array.pager_title)[0],
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp,0.dp,16.dp,0.dp),
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = context.resources.getStringArray(R.array.pager_desc)[0],
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp,0.dp,16.dp,0.dp),
                        textAlign = TextAlign.Start
                    )
                    Row(
                        Modifier
                            .wrapContentHeight()
                            .fillMaxWidth()
                            .width(IntrinsicSize.Min)
                            .padding(all = 16.dp),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Center

                    ) {
                        SignUpButton(
                            text = context.resources.getString(R.string.signUp),
                            navHostController = navHostController,
                            modifier = Modifier
                                .weight(1f)
                                .padding(8.dp)
                                .wrapContentHeight()

                        )
                        Spacer(
                            modifier = Modifier.width(10.dp)
                        )
                        LoginButton(
                            text = context.resources.getString(R.string.login),
                            navHostController = navHostController,
                            modifier = Modifier
                                .weight(1f)
                                .padding(8.dp)
                                .fillMaxWidth()
                                .wrapContentHeight()
                        )
                    }
                }
            }

        }

    }

}

@Composable
private fun SignUpButton(text: String, modifier: Modifier, navHostController: NavHostController) {
    val context = LocalContext.current
    FilledTonalButton(modifier = modifier, colors =
    ButtonDefaults.filledTonalButtonColors(
        containerColor = colorResource(id = R.color.colorBlue),
        contentColor = colorResource(id = R.color.white)
    ),
        onClick = {
            navHostController.navigate(NavigationItems.SignUp.route)
        }) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            color = colorResource(id = R.color.white),
            fontSize = 18.sp
        )
    }
}

@Composable
private fun LoginButton(text: String, modifier: Modifier, navHostController: NavHostController) {
    val context = LocalContext.current
    FilledTonalButton(modifier = modifier,
        colors = ButtonDefaults.filledTonalButtonColors(
            containerColor = colorResource(id = R.color.white),
            contentColor = colorResource(id = R.color.colorBlue)
        ),
        border = BorderStroke(width = 1.dp, color = colorResource(id = R.color.colorBlue)),
        onClick = { navHostController.navigate(NavigationItems.Login.route) }) {
        Text(text = text, textAlign = TextAlign.Center, color = Color.Blue, fontSize = 18.sp)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

private fun ShowToast(context: Context, msg: String) {
    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}