package com.stu71205.ca3_movie_booking_app.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.stu71205.ca3_movie_booking_app.navigation.Routes
import com.stu71205.ca3_movie_booking_app.services.WomenClothing
import com.stu71205.ca3_movie_booking_app.services.WomenClothingService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun WomenClothingList(navController: NavHostController) {
    var womenClothing by remember { mutableStateOf(emptyList<WomenClothing>()) }

    LaunchedEffect(Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val womenClothingService = retrofit.create(WomenClothingService::class.java)
            womenClothing = womenClothingService.getWomenClothing()
        }
    }

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(womenClothing) { womenClothing ->
            WomenClothing(womenClothing = womenClothing, navController = navController)
        }
    }
}


@OptIn(ExperimentalCoilApi::class)
@Composable
fun WomenClothing(womenClothing: WomenClothing, navController: NavHostController) {
    val image = rememberImagePainter(data = womenClothing.image)
    val description = womenClothing.description

    Spacer(modifier = Modifier.width(8.dp))

    Image(
        painter = image,
        contentDescription = null,
        modifier = Modifier
            .fillMaxWidth()
            .width(50.dp)
            .height(50.dp)
            .clickable(
                onClick = {
                    navController.navigate(Routes.ShowDescription.route)
                }
            )
    )
    Text(text = womenClothing.title)
    Text(text = womenClothing.price)
    Text(text = womenClothing.category)
}


