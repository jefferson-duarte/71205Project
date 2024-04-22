package com.stu71205.ca3_movie_booking_app.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.stu71205.ca3_movie_booking_app.PartBottomBar
import com.stu71205.ca3_movie_booking_app.models.WomenClothingViewModel
import com.stu71205.ca3_movie_booking_app.services.WomenClothing

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WomenClothingList(navController: NavHostController, onClicked: (WomenClothing) -> Unit) {
    val viewModel: WomenClothingViewModel = viewModel()

    LaunchedEffect(Unit) {
        viewModel.fetchWomenClothing()
    }
    val womenClothing by viewModel.womenClothing.observeAsState(emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Gray,
                    titleContentColor = Color.White,
                ),
                title = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            "WOMEN CLOTHING",
                            modifier = Modifier
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar (
                containerColor = Color.Gray,
                contentColor = Color.White,
            ){
                PartBottomBar(navController)
            }
        },
    ) { innerPadding ->
        LazyVerticalGrid(
            GridCells.Adaptive(minSize = 220.dp),
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(color = Color.LightGray)
        ) {
            itemsIndexed(womenClothing) { index, womenClothing ->
                Box(
                    modifier = Modifier
                        .clickable {
                            onClicked(womenClothing)
                        }
                        .padding(8.dp)
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .background(color = Color.White)
                        .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(8.dp))
                ) {
                    Column(
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Image(
                            painter = rememberImagePainter(data = womenClothing.image),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f)
                                .clip(shape = RoundedCornerShape(8.dp)),
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = womenClothing.title,
                            style = MaterialTheme.typography.titleLarge,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )

                        Text(
                            text = "€${String.format("%.2f", womenClothing.price.toDouble())}",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )

                        Text(
                            text = womenClothing.category,
                            style = MaterialTheme.typography.titleSmall,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }
            }
        }
    }
}
