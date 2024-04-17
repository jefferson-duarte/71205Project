package com.stu71205.ca3_movie_booking_app.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberImagePainter
import com.stu71205.ca3_movie_booking_app.R
import com.stu71205.ca3_movie_booking_app.navigation.Routes
import com.stu71205.ca3_movie_booking_app.PartBottomBar

@OptIn(ExperimentalMaterial3Api::class)
@ExperimentalCoilApi
@Composable
fun ProductDescription(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Gray,
                    titleContentColor = Color.White,
                ),
                title = {
                    Row (
                        modifier = Modifier
                            .fillMaxWidth(0.87f)
                    ){

                        Text(
                            "WD 2TB Elements",
                            modifier = Modifier
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.Bold,
                        )
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
    ) {innerPadding ->
        Column(
            modifier = Modifier
                .background(color = Color.White)
                .padding(innerPadding)
                .fillMaxSize(),
//            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){

            Image(
                painter = rememberImagePainter(data = "Product Image"),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Text(
                text = "WD 2TB Elements",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Text(
                text = "Product Description",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Text(
                text = "Price: €64.00",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 16.dp)
            ) {

                var quantity by remember { mutableStateOf(1) }
                OutlinedButton(
                    onClick = { if (quantity > 1) quantity-- },
                    modifier = Modifier.padding(end = 16.dp)
                ) {
                    Image(
                        modifier = Modifier
                            .requiredSize(20.dp),
                        painter = painterResource(id = R.drawable.minus),
                        contentDescription = "minus"
                    )
                }
                Text(
                    text = quantity.toString(),
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                OutlinedButton(
                    onClick = { quantity++ },
                    modifier = Modifier.padding(start = 16.dp)
                ) {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "Add"
                    )
                }
            }

            Row (
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                Button(onClick = {
                    navController.navigate(Routes.CartSummaryScreen.route)
                }) {
                    Text(text = "Buy")
                }
            }
        }
    }
}
