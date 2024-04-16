package com.stu71205.ca3_movie_booking_app.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.stu71205.ca3_movie_booking_app.navigation.Routes

@Composable
fun PartBottomBar(navController: NavController){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        IconButton(onClick = { navController.navigate(Routes.Home.route) }) {
            Icon(
                Icons.Default.Home,
                contentDescription = "Home",
                modifier = Modifier
                    .size(35.dp)
            )
        }
        IconButton(onClick = {}) {
            Icon(
                Icons.Default.Search,
                contentDescription = "Search",
                modifier = Modifier
                    .size(35.dp)
            )

        }
        IconButton(onClick = {}) {
            Icon(
                Icons.Default.Settings,
                contentDescription = "Settings",
                modifier = Modifier
                    .size(35.dp)
            )
        }
    }
}