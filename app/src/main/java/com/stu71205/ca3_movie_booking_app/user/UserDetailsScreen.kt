package com.stu71205.ca3_movie_booking_app.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.stu71205.ca3_movie_booking_app.PartBottomBar
import com.stu71205.ca3_movie_booking_app.navigation.Routes
import com.stu71205.ca3_movie_booking_app.services.User
import com.stu71205.ca3_movie_booking_app.services.UserService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@OptIn(ExperimentalMaterial3Api::class, ExperimentalCoilApi::class)
@Composable
fun UserDetailsScreen(navController: NavHostController) {
    var user by remember { mutableStateOf<User?>(null) }
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            user = UserApi.service.getUser(1)
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Gray,
                    titleContentColor = Color.White,
                ),
                title = {

                    Row(
                        modifier = Modifier.fillMaxWidth(0.87f)

                    ) {

                        Image(
                            painter = rememberImagePainter(data = "Product Image"),
                            contentDescription = "Logo",
                            modifier = Modifier
                                .size(40.dp)
                        )

                        Text(
                            "Welcome - ${user?.name?.firstname} ${user?.name?.lastname}",
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
            BottomAppBar(
                containerColor = Color.Gray,
                contentColor = Color.White,
            ) {
                PartBottomBar(navController)
            }
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .background(color = Color.White)
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            RandomPersonImage()

            Text(text = "User Details", style = MaterialTheme.typography.headlineLarge)

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Username:", style = MaterialTheme.typography.bodyLarge)
            user?.let { Text(text = it.username, style = MaterialTheme.typography.bodyMedium) }

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = "Name:", style = MaterialTheme.typography.bodyLarge)
            Text(text = "${user?.name?.firstname} ${user?.name?.lastname}", style = MaterialTheme.typography.bodyMedium)

            Text(text = "Email:", style = MaterialTheme.typography.bodyLarge)
            user?.let { Text(text = it.email, style = MaterialTheme.typography.bodyMedium) }

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Address:", style = MaterialTheme.typography.bodyLarge)
            Text(text = "${user?.address?.number}, ${user?.address?.street}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "${user?.address?.city}, ${user?.address?.zipcode}", style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Phone:", style = MaterialTheme.typography.bodyLarge)
            user?.let { Text(text = it.phone, style = MaterialTheme.typography.bodyMedium) }

            Spacer(modifier = Modifier.height(8.dp))

            Button(onClick = { navController.navigate(Routes.AboutScreen.route) }) {
                Text("About this app")
            }
        }
    }
}

object UserApi {
    private const val BASE_URL = "https://fakestoreapi.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: UserService by lazy {
        retrofit.create(UserService::class.java)
    }
}

@Composable
fun RandomPersonImage() {
    val imageUrl = "https://thispersondoesnotexist.com"
    val painter: Painter = rememberImagePainter(
        data = imageUrl
    )

    Image(
        painter = painter,
        contentDescription = "PersonImage",
        modifier = Modifier
            .size(200.dp),
        contentScale = ContentScale.Crop
    )
}