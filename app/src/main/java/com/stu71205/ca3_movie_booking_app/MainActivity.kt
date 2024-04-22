package com.stu71205.ca3_movie_booking_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.stu71205.ca3_movie_booking_app.models.AuthViewModel
import com.stu71205.ca3_movie_booking_app.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val authViewModel = ViewModelProvider(this)[AuthViewModel::class.java]
            AppNavigation(authViewModel = authViewModel)
        }
    }
}

/*
user@gmail.com
123456
*/