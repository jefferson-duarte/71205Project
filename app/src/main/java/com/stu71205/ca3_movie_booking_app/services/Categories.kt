package com.stu71205.ca3_movie_booking_app.services

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
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

            when (category) {
                "electronics" -> {
                    Text(
                        text = category,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 18.sp,
                        modifier = Modifier.clickable {
                            navController.navigate(Routes.ElectronicListScreen.route)
                        }
                    )
                }
                "jewelery" -> {
                    Text(
                        text = category,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 18.sp,
                        modifier = Modifier.clickable {
                            navController.navigate(Routes.JeweleryListScreen.route)
                        }
                    )
                }
                "men's clothing" -> {
                    Text(
                        text = category,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 18.sp,
                        modifier = Modifier.clickable {
                            navController.navigate(Routes.MenClothingListScreen.route)
                        }
                    )
                }
                "women's clothing" -> {
                    Text(
                        text = category,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 18.sp,
                        modifier = Modifier.clickable {
                            navController.navigate(Routes.WomenClothingListScreen.route)
                        }
                    )
                }
            }
        }
    }
}