package com.stu71205.ca3_movie_booking_app.services

data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val quantity: Int
)

data class Electronics(
    val id: String,
    val title: String,
    val price: String,
    val category: String,
    val description: String,
    val image: String,
)

data class Jeweleries(
    val id: String,
    val title: String,
    val price: String,
    val category: String,
    val description: String,
    val image: String,
)

data class MenClothing(
    val id: String,
    val title: String,
    val price: String,
    val category: String,
    val description: String,
    val image: String,
)

data class WomenClothing(
    val id: String,
    val title: String,
    val price: String,
    val category: String,
    val description: String,
    val image: String,
)
