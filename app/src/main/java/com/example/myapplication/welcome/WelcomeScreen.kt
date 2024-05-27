package com.example.myapplication.welcome

import android.content.Context
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
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myapplication.R
import com.example.myapplication.helper.NavigationItems
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeScreen(modifier: Modifier = Modifier, navHostController: NavHostController) {

    val context = LocalContext.current
    val pagerState = rememberPagerState(pageCount = {
        3
    })
    Column(
        Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        HorizontalPager(state = pagerState) { page ->
            Column(modifier = Modifier, verticalArrangement = Arrangement.Center) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    painter = painterResource(id = if (page == 0) R.drawable.ic_pager1 else if (page == 1) R.drawable.ic_pager2 else R.drawable.ic_pager3),
                    contentDescription = stringResource(id = R.string.app_name)
                )

                Text(
                    text = context.resources.getStringArray(R.array.pager_title)[page.absoluteValue],
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    textAlign = TextAlign.Center
                )
                Text(
                    text = context.resources.getStringArray(R.array.pager_desc)[page.absoluteValue],
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    textAlign = TextAlign.Center
                )
            }
        }

        var isLastItemVisible = pagerState.currentPage == 2

        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = 8.dp, top = 5.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }
        if (isLastItemVisible) {
            Row(
                Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .width(IntrinsicSize.Min)
                    .padding(all = 16.dp),
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