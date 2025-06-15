package com.cozycraft.android.welcome

import android.content.Context
import android.graphics.BitmapFactory
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.cozycraft.android.custom.CustomButton
import com.cozycraft.android.navigation.login.NavigationItems
import com.cozycraft.android.theme.Typography
import com.cozycraft.android.R

@Composable
fun WelcomeScreen(navHostController: NavHostController) {

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
                        .fillMaxSize().fillMaxHeight(),
                    painter = painterResource(id = R.drawable.ic_toturial),
                    contentDescription = stringResource(id = R.string.app_name),
                    contentScale = ContentScale.FillHeight,
                )
                Column(
                    Modifier
                        .fillMaxHeight()
                        .padding(0.dp, 0.dp, 0.dp, 18.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        text = context.resources.getString(R.string.welcome_screen_title),
                        style = Typography.titleLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp, 0.dp, 16.dp, 0.dp),
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = context.resources.getString(R.string.welcome_screen_desc),
                        style = Typography.bodyLarge,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp, 0.dp, 16.dp, 0.dp),
                        textAlign = TextAlign.Start
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(all = 16.dp)
                    ) {
                        CustomButton(
                            text = context.resources.getString(R.string.signUp),
                            onClick = {
                                navHostController.navigate(NavigationItems.SignUp.route)
                            },
                            modifier = Modifier
                                .weight(1f)
                                .padding(8.dp)
                                .wrapContentHeight(),

                            )
                        Spacer(
                            modifier = Modifier.weight(0.1f) // Adjust weight for desired spacing
                        )
                        CustomButton(
                            text = context.resources.getString(R.string.login),
                            onClick = {
                                navHostController.navigate(NavigationItems.Login.route)
                            },
                            modifier = Modifier
                                .weight(1f)
                                .padding(8.dp)
                                .fillMaxWidth()
                                .wrapContentHeight(),
                        )
                    }
                }
            }

        }

    }


}

fun getImageAspectRatio(context: Context, imageId: Int): Float {
    val options = BitmapFactory.Options().apply { inJustDecodeBounds = true }
    BitmapFactory.decodeResource(context.resources, imageId, options)
    return options.outWidth.toFloat() / options.outHeight.toFloat()
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