package com.stu71205.ca3_movie_booking_app.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stu71205.ca3_movie_booking_app.services.MenClothing
import com.stu71205.ca3_movie_booking_app.services.MenClothingService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MenClothingViewModel : ViewModel() {
    private val _menClothing = MutableLiveData<List<MenClothing>>()
    val menClothing: LiveData<List<MenClothing>> = _menClothing

    fun fetchMenClothing() {
        viewModelScope.launch {
            try {
                val fetchedMenClothing = withContext(Dispatchers.IO) {
                    val retrofit = Retrofit.Builder()
                        .baseUrl("https://fakestoreapi.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                    val menClothingService = retrofit.create(MenClothingService::class.java)
                    menClothingService.getMenClothing()
                }
                _menClothing.value = fetchedMenClothing
            } catch (e: Exception) {
                Log.e("MenClothingViewModel", "Error to get men clothing", e)
            }
        }
    }
}