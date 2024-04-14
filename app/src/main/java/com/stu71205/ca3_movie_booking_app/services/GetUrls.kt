package com.stu71205.ca3_movie_booking_app.services

import retrofit2.http.GET

interface CategoriesService {
    @GET("/products/categories")
    suspend fun getCategories(): List<String>
}

interface ElectronicsService {
    @GET("/products/category/electronics")
    suspend fun getElectronics(): List<Electronics>
}

interface JeweleriesService {
    @GET("/products/category/jewelery")
    suspend fun getJeweleries(): List<Jeweleries>
}

interface MenClothingService {
    @GET("/products/category/men's%20clothing")
    suspend fun getMenClothing(): List<MenClothing>
}

interface WomenClothingService {
    @GET("/products/category/women's%20clothing")
    suspend fun getWomenClothing(): List<WomenClothing>
}
