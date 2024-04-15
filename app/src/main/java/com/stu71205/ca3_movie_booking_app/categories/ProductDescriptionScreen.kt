package com.stu71205.ca3_movie_booking_app.categories

import android.os.Bundle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavDeepLinkRequest
import com.stu71205.ca3_movie_booking_app.navigation.Routes


@Composable
fun ShowDescription(navController: NavHostController) {
}

@ExperimentalCoilApi
@Composable
fun ProductDescription(navController: NavHostController, electronicViewModel: ElectronicViewModel) {
    LaunchedEffect(Unit) {
        electronicViewModel.fetchElectronics()
    }

    val electronics by electronicViewModel.electronics.observeAsState(emptyList())

    LazyColumn {
        items(electronics) { electronic ->
            Column() {
                Text(text = electronic.title)
            }
        }
    }
}
//
//    Spacer(modifier = Modifier.width(8.dp))
//
//    Text(text = "title")
//    Text(text = "price")
//    Text(text = "category")
//
//    val quantity by remember { mutableIntStateOf(1) }
//    Column(
//        modifier = Modifier.padding(16.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(
//                text = "",
//                style = TextStyle(fontSize = 16.sp),
//                textAlign = TextAlign.Center,
//                modifier = Modifier.fillMaxWidth()
//            )
//
//            Row(verticalAlignment = Alignment.CenterVertically) {
//                Button(
//                    onClick = { },
//                    enabled = quantity > 1
//                ) {
//                    Text(text = "-")
//                }
//
//                Text(text = quantity.toString())
//
//                Button(
//                    onClick = {}
//                ) {
//                    Text(text = "+")
//                }
//            }
//
//            Button(
//                onClick = {}
//            ) {
//                Text(text = "Comprar")
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
////            Button(
////                onClick = { navController.popBackStack() }
////            ) {
////                Text(text = "Voltar")
////            }
//        }
//}
