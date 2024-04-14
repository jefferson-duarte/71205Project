package com.stu71205.ca3_movie_booking_app

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.stu71205.ca3_movie_booking_app.services.CategoriesListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Gray,
                    titleContentColor = Color.White
                ),
                title = {
                    Text(
                        text = "MOVIES",
                        textAlign = TextAlign.Center
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar (
                containerColor = Color.Gray,
                contentColor = Color.White,

                ){
            }
        },
    ) {innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = Color.White)
//                .verticalScroll(rememberScrollState())
        ){
            Column(
                modifier = Modifier
                    .background(color = Color.Yellow)
                    .padding(innerPadding)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
            ){
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
//                        Text(text = "A")
                    CategoriesListScreen(navController)
//                        ProductListScreen()
//                    ElectronicList()
//                        MovieScree1(onClick = {
//                            navController.navigate(Routes.FirstScreen.route)
//                        })
//
//                        Spacer(modifier = Modifier.width(40.dp))
//
//                        MovieScree2(onClick = {
//                            navController.navigate(Routes.SecondScreen.route)
//                        })
                }
            }
        }
    }
}