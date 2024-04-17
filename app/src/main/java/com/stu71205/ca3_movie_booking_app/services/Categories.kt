package com.stu71205.ca3_movie_booking_app.services

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.stu71205.ca3_movie_booking_app.navigation.Routes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Composable
fun CategoriesListScreen(navController: NavController) {
    var categories by remember { mutableStateOf(emptyList<String>()) }

    LaunchedEffect(Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val categoriesService = retrofit.create(CategoriesService::class.java)
            categories = categoriesService.getCategories()
        }
    }

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(categories) { category ->
            val icon = when (category) {
                "electronics" -> Icons.Default.Build
                "jewelery" -> Icons.Default.Favorite
                "men's clothing" -> Icons.Default.ThumbUp
                "women's clothing" -> Icons.Default.Face
                else -> Icons.Default.Home
            }

            Row(
                modifier = Modifier
                    .clickable {
                        navController.navigate(getRoute(category))
                    }
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Category Icon",
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    modifier = Modifier
                        .fillMaxSize(),
                    textAlign = TextAlign.Center,
                    text = category,
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 18.sp
                )
            }
        }
    }
}

fun getRoute(category: String): String {
    return when (category) {
        "electronics" -> Routes.ElectronicListScreen.route
        "jewelery" -> Routes.JeweleryListScreen.route
        "men's clothing" -> Routes.MenClothingListScreen.route
        "women's clothing" -> Routes.WomenClothingListScreen.route
        else -> ""
    }
}