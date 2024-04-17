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

data class User(
    val id: Int,
    val username: String,
    val name: UserName,
    val email: String,
    val address: Address,
    val phone: String,
)

data class UserName(
    val firstname: String,
    val lastname: String
)

data class Address(
    val street: String,
    val number: Int,
    val city: String,
    val zipcode: String,
    val geolocation: Geo
)

data class Geo(
    val lat: String,
    val long: String
)
