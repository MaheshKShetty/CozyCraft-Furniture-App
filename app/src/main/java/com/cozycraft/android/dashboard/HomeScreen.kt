package com.cozycraft.android.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.cozycraft.android.data.HomeResponseItem
import com.cozycraft.android.helper.Utils
import com.cozycraft.android.theme.Typography

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val furnitureList = Utils.readJsonFromRaw(context)

    LazyColumn(modifier = modifier.fillMaxSize().padding(16.dp)) {
        items(furnitureList) { furnitureItem ->
            FurnitureCard(furnitureItem)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FurnitureCard(furnitureItem: HomeResponseItem) {
    var isFavorite by remember { mutableStateOf(false)}
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        onClick = { } ,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box {
                Image(
                    painter = rememberAsyncImagePainter(furnitureItem.imageUrl),
                    contentDescription = furnitureItem.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.FillWidth
                )
                IconButton(
                    modifier = Modifier.align(Alignment.TopEnd),
                    onClick = { isFavorite = !isFavorite }) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                        contentDescription = if (isFavorite) "Remove from favorites" else "Add to favorites",
                        tint = if (isFavorite) Color.Red else Color.DarkGray
                    )
                }
            }
        }

        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(8.dp))
            furnitureItem.title?.let { Text(it, style = Typography.titleLarge, fontWeight = FontWeight.Bold) }
            Spacer(modifier = Modifier.height(4.dp))
            furnitureItem.description?.let { Text(it, style = Typography.bodyMedium) }
            Spacer(modifier = Modifier.height(4.dp))
            Text("${furnitureItem.date}", style = Typography.bodySmall)
        }
    }
}
