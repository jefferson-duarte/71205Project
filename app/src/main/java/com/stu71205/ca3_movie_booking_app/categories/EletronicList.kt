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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.stu71205.ca3_movie_booking_app.navigation.Routes

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
            val image = rememberImagePainter(data = electronic.image)

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
                            navController.navigate(Routes.ProductDescriptionScreen.route)
                        }
                    )
            )
            Text(text = electronic.title)
            Text(text = electronic.price)
            Text(text = electronic.category)
        }
    }
}
