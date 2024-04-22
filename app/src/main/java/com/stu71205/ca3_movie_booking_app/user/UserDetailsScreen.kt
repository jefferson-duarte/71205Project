package com.stu71205.ca3_movie_booking_app.user

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.stu71205.ca3_movie_booking_app.PartBottomBar
import com.stu71205.ca3_movie_booking_app.navigation.Routes
import com.stu71205.ca3_movie_booking_app.services.User
import com.stu71205.ca3_movie_booking_app.services.UserService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@OptIn(ExperimentalMaterial3Api::class)
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
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(Color.LightGray)
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                RandomPersonImage()
            }

            UserDetailCard(label = "Username:", value = user?.username ?: "-")
            UserDetailCard(label = "Name:", value = "${user?.name?.firstname ?: ""} ${user?.name?.lastname ?: ""}")
            UserDetailCard(label = "Email:", value = user?.email ?: "-")
            UserDetailCard(label = "Address:", value = "${user?.address?.number ?: ""}, ${user?.address?.street ?: ""}, ${user?.address?.city ?: ""}, ${user?.address?.zipcode ?: ""}")
            UserDetailCard(label = "Phone:", value = user?.phone ?: "-")

            Button(
                onClick = { navController.navigate(Routes.AboutScreen.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("About this app")
            }
        }
    }
}

@Composable
fun UserDetailCard(label: String, value: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = label, style = MaterialTheme.typography.bodyLarge)
        Text(text = value, style = MaterialTheme.typography.bodyMedium)
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
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .size(200.dp)
            .border(
                width = 2.dp,
                color = Color.DarkGray,
                shape = RectangleShape,
            ),
        contentScale = ContentScale.Crop
    )
}