package com.stu71205.ca3_movie_booking_app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stu71205.ca3_movie_booking_app.Home
import com.stu71205.ca3_movie_booking_app.categories.ElectronicList
import com.stu71205.ca3_movie_booking_app.categories.JeweleryList
import com.stu71205.ca3_movie_booking_app.categories.MenClothingList
import com.stu71205.ca3_movie_booking_app.categories.ShowDescription
import com.stu71205.ca3_movie_booking_app.categories.WomenClothingList

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Home.route,
    )
    {
        composable(route = Routes.Home.route)
        {
            Home(navController = navController)
        }

        composable(route = Routes.ShowDescription.route)
        {
            ShowDescription(navController = navController)
        }

        composable(route = Routes.ElectronicListScreen.route)
        {
            ElectronicList(navController = navController)
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
    }
}