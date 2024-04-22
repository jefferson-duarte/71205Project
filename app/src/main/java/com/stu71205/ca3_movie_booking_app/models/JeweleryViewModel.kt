package com.stu71205.ca3_movie_booking_app.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stu71205.ca3_movie_booking_app.services.Jeweleries
import com.stu71205.ca3_movie_booking_app.services.JeweleriesService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class JeweleryViewModel : ViewModel() {
    private val _jeweleries = MutableLiveData<List<Jeweleries>>()
    val jeweleries: LiveData<List<Jeweleries>> = _jeweleries

    fun fetchJewelery() {
        viewModelScope.launch {
            try {
                val fetchedJeweleries = withContext(Dispatchers.IO) {
                    val retrofit = Retrofit.Builder()
                        .baseUrl("https://fakestoreapi.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                    val jeweleriesService = retrofit.create(JeweleriesService::class.java)
                    jeweleriesService.getJeweleries()
                }
                _jeweleries.value = fetchedJeweleries
            } catch (e: Exception) {
                Log.e("JeweleryViewModel", "Error to get jeweleries", e)
            }
        }
    }
}