package com.stu71205.ca3_movie_booking_app.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stu71205.ca3_movie_booking_app.services.Electronics
import com.stu71205.ca3_movie_booking_app.services.ElectronicsService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ElectronicViewModel : ViewModel() {
    private val _electronics = MutableLiveData<List<Electronics>>()
    val electronics: LiveData<List<Electronics>> = _electronics

    fun setElectronics(list: List<Electronics>) {
        _electronics.value = list
    }

    fun fetchElectronics() {
        viewModelScope.launch {
            try {
                val fetchedElectronics = withContext(Dispatchers.IO) {
                    val retrofit = Retrofit.Builder()
                        .baseUrl("https://fakestoreapi.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                    val electronicsService = retrofit.create(ElectronicsService::class.java)
                    electronicsService.getElectronics()
                }
                _electronics.value = fetchedElectronics
            } catch (e: Exception) {
                Log.e("ElectronicViewModel", "Error to get electronics", e)
            }
        }
    }
}