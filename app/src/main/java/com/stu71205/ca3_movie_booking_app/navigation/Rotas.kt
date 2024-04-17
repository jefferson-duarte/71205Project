package com.stu71205.ca3_movie_booking_app.navigation

sealed class Routes (val route: String){
    object Home : Routes(route = "home_screen")
    object ShowDescription : Routes(route = "show_description_screen")
    object ElectronicListScreen : Routes(route = "electronic_screen")
    object JeweleryListScreen : Routes(route = "jewelery_screen")
    object MenClothingListScreen : Routes(route = "men_clothing_screen")
    object WomenClothingListScreen : Routes(route = "women_clothing_screen")
    object ProductDescriptionScreen : Routes(route = "product_description_screen")
    object CartSummaryScreen : Routes(route = "cart_summary_screen")
    object UserDetailsScreen : Routes(route = "user_details_screen")
}