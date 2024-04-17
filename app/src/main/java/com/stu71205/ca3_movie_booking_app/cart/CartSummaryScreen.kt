package com.stu71205.ca3_movie_booking_app.cart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.stu71205.ca3_movie_booking_app.PartBottomBar
import com.stu71205.ca3_movie_booking_app.services.Product

val products = listOf(
    Product(1, "WD 2TB Elements", 64.00, 2),
    Product(2, "SanDisk SSD PLUS 1TB", 109.95, 1),
    Product(3, "Silicone Power 256GB SSD", 109.50, 3)
)

@OptIn(ExperimentalMaterial3Api::class, ExperimentalCoilApi::class)
@Composable
fun CartSummaryScreen(navController: NavHostController) {
    var cartItems by remember { mutableStateOf(products) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Gray,
                    titleContentColor = Color.White,
                ),
                title = {

                    Row (
                        modifier = Modifier.fillMaxWidth(0.87f)

                    ){

                        Image(
                            painter = rememberImagePainter(data = "Product Image"),
                            contentDescription = "Logo",
                            modifier = Modifier
                                .size(40.dp)
                        )

                        Text(
                            "Cart Summary",
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
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {

            }
            cartItems.forEach { product ->
                CartItemRow(product)
            }

            Spacer(modifier = Modifier.height(16.dp))

            CartSummarySection(cartItems)

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(text = "Place Order")
            }

        }
    }
}

@Composable
fun CartItemRow(product: Product) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "${product.quantity}x ${product.name}")

        Spacer(modifier = Modifier.weight(1f))

        Text(text = "$${product.price * product.quantity}")
    }
}

@Composable
fun CartSummarySection(cartItems: List<Product>) {
    val subtotal = cartItems.sumOf { it.price * it.quantity }
    val shipping = 5.99
    val total = subtotal + shipping

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            "Subtotal: $$subtotal",
            style = MaterialTheme
                .typography.titleLarge
        )
        Text(
            "Shipping: $$shipping",
            style = MaterialTheme
                .typography.titleLarge
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Total: ${String.format("%.2f", total)}",
            style = MaterialTheme
                .typography.headlineSmall
        )
    }
}
