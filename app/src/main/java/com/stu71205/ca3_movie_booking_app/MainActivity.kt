package com.stu71205.ca3_movie_booking_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.stu71205.ca3_movie_booking_app.navigation.AppNavigation
import com.stu71205.ca3_online_shopping_app.auth_user.MyApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
//            MyApp()
        }
    }
}

