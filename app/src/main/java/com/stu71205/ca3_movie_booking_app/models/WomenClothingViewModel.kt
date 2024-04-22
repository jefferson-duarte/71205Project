package com.stu71205.ca3_movie_booking_app.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stu71205.ca3_movie_booking_app.services.Electronics
import com.stu71205.ca3_movie_booking_app.services.ElectronicsService
import com.stu71205.ca3_movie_booking_app.services.WomenClothing
import com.stu71205.ca3_movie_booking_app.services.WomenClothingService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WomenClothingViewModel : ViewModel() {
    private val _womenClothing = MutableLiveData<List<WomenClothing>>()
    val womenClothing: LiveData<List<WomenClothing>> = _womenClothing

    fun fetchWomenClothing() {
        viewModelScope.launch {
            try {
                val fetchedElectronics = withContext(Dispatchers.IO) {
                    val retrofit = Retrofit.Builder()
                        .baseUrl("https://fakestoreapi.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                    val womenClothingService = retrofit.create(WomenClothingService::class.java)
                    womenClothingService.getWomenClothing()
                }
                _womenClothing.value = fetchedElectronics
            } catch (e: Exception) {
                Log.e("WomenClothingViewModel", "Error to get women clothing", e)
            }
        }
    }
}