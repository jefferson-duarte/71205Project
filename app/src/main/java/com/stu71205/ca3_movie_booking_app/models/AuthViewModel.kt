package com.stu71205.ca3_movie_booking_app.models

import androidx.compose.material3.Text
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class AuthViewModel(private val authRepository: AuthRepository) : ViewModel() {
    constructor() : this(AuthRepository())

    private val _loggedIn = MutableLiveData<Boolean>()
    val loggedIn: LiveData<Boolean>
        get() = _loggedIn

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val user = authRepository.login(email, password)
            if (user != null) {

                _loggedIn.value = true
            } else {

                _loggedIn.value = false
            }
        }
    }
}
