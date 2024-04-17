package com.stu71205.ca3_movie_booking_app.categories

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.stu71205.ca3_movie_booking_app.navigation.Routes
import com.stu71205.ca3_movie_booking_app.services.getRoute

@OptIn(ExperimentalCoilApi::class)
@Composable
fun ElectronicList(navController: NavHostController, electronicViewModel: ElectronicViewModel) {

    LaunchedEffect(Unit) {
        electronicViewModel.fetchElectronics()
    }
    val electronics by electronicViewModel.electronics.observeAsState(emptyList())

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(electronics) { electronic ->
            Column(
                modifier = Modifier
                    .clickable {
                        navController.navigate(Routes.ProductDescriptionScreen.route)
                    }
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Image(
                    painter = rememberImagePainter(data = electronic.image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )

                Text(
                    text = electronic.title,
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(
                    text = electronic.price,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = electronic.category,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
    }
}
