package com.stu71205.ca3_movie_booking_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.stu71205.ca3_movie_booking_app.Home
import com.stu71205.ca3_movie_booking_app.auth_login.MyApp
import com.stu71205.ca3_movie_booking_app.cart.CartSummaryScreen
import com.stu71205.ca3_movie_booking_app.categories.ElectronicList
import com.stu71205.ca3_movie_booking_app.categories.JeweleryList
import com.stu71205.ca3_movie_booking_app.categories.MenClothingList
import com.stu71205.ca3_movie_booking_app.categories.ProductDescription
import com.stu71205.ca3_movie_booking_app.categories.ProductList
import com.stu71205.ca3_movie_booking_app.categories.WomenClothingList
import com.stu71205.ca3_movie_booking_app.models.AuthViewModel
import com.stu71205.ca3_movie_booking_app.user.AboutScreen
import com.stu71205.ca3_movie_booking_app.user.UserDetailsScreen

@OptIn(ExperimentalCoilApi::class)
@Composable
fun AppNavigation(authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Home.route,
    )
    {
        composable(route = Routes.LoginScreen.route)
        {
            MyApp(navController = navController, authViewModel = authViewModel)
        }

        composable(route = Routes.Home.route)
        {
            Home(navController = navController)
        }

        composable(route = Routes.ElectronicListScreen.route)
        {
            ElectronicList(navController = navController) { electronic ->
                navController.navigate("${Routes.ProductDescriptionScreen.route}/${electronic.id}")
            }
        }

        composable(route = Routes.JeweleryListScreen.route)
        {
            JeweleryList(navController = navController)
        }

        composable(route = Routes.MenClothingListScreen.route)
        {
            MenClothingList(navController = navController)
        }

        composable(route = Routes.WomenClothingListScreen.route)
        {
            WomenClothingList(navController = navController)
        }

        composable(route = Routes.ProductDescriptionScreen.route + "/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")
            ProductDescription(navController = navController, productId = productId)
        }

        composable(
            route = Routes.CartSummaryScreen.route + "/{quantity}/{totalPrice}",
            arguments = listOf(
                navArgument("quantity") { type = NavType.IntType },
                navArgument("totalPrice") { type = NavType.FloatType },
            )
        ) { navBackStackEntry ->
            val quantity = navBackStackEntry.arguments?.getInt("quantity") ?: 0
            val totalPrice = navBackStackEntry.arguments?.getFloat("totalPrice") ?: 0.0f
            CartSummaryScreen(navController = navController, quantity = quantity, totalPrice = totalPrice.toDouble())
        }

        composable(route = Routes.UserDetailsScreen.route)
        {
            UserDetailsScreen(navController = navController)
        }

        composable(route = Routes.ProductListScreen.route)
        {
            ProductList(navController = navController)
        }

        composable(route = Routes.AboutScreen.route)
        {
            AboutScreen(navController = navController)
        }

    }
}