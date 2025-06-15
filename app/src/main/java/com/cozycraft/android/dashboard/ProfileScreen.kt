package com.cozycraft.android.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.cozycraft.android.theme.Typography
import com.cozycraft.android.R

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_profile_placeholder),
            contentDescription = "Profile Icon",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape).align(Alignment.CenterHorizontally)
        )

        Text(
            text = "User Name",
            style = Typography.bodyLarge,
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "user@email.com",
            style = Typography.bodyLarge,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
            items(listOf("Your Orders", "Favorites", "Language",
                "About Us", "FAQ",
                "Terms and Conditions",
                "Contact Us",
                "Delete Account", "Logout")) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier= Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = when (item) {
                                "Your Orders" -> Icons.Filled.ShoppingCart
                                "Favorites" -> Icons.Filled.Favorite
                                "About Us" -> Icons.Filled.Info
                                "FAQ" -> Icons.Filled.Build
                                "Language" -> Icons.Filled.Settings
                                "Delete Account" -> Icons.Filled.Delete
                                 "Contact Us"  -> Icons.Filled.Call
                                "Terms and Conditions" -> Icons.Filled.Warning
                                "Logout" -> Icons.AutoMirrored.Filled.ExitToApp
                                else -> Icons.Filled.AddCircle},
                            contentDescription = item,
                            modifier = Modifier.size(24.dp)
                        )

                        Text(
                            text = item,
                            style = Typography.bodyLarge,
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 16.dp)
                        )

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = "Go to $item",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }
    }
}