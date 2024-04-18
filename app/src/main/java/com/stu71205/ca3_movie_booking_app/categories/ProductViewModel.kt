package com.stu71205.ca3_movie_booking_app.categories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stu71205.ca3_movie_booking_app.services.Product
import com.stu71205.ca3_movie_booking_app.services.ProductService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductViewModel : ViewModel() {
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    fun fetchProducts() {
        viewModelScope.launch {
            try {
                val fetchedProducts = withContext(Dispatchers.IO) {
                    ProductApi.service.getProducts()
                }
                _products.value = fetchedProducts
            } catch (e: Exception) {
                Log.e("ProductViewModel", "Error to get products", e)
            }
        }
    }

    object ProductApi {
        private const val BASE_URL = "https://fakestoreapi.com/"

        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: ProductService by lazy {
            retrofit.create(ProductService::class.java)
        }
    }
}

