package com.stu71205.ca3_movie_booking_app.auth_login

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
//
//@HiltViewModel
//class SignInViewModel @Inject constructor(
//    private val accountService: AccountService
//) : NotesAppViewModel() {
//    val email = MutableStateFlow("")
//    val password = MutableStateFlow("")
//
//    fun updateEmail(newEmail: String) {
//        email.value = newEmail
//    }
//
//    fun updatePassword(newPassword: String) {
//        password.value = newPassword
//    }
//
//    fun onSignInClick(openAndPopUp: (String, String) -> Unit) {
//        launchCatching {
//            accountService.signIn(email.value, password.value)
//            openAndPopUp(AuthenticationScreen())
//        }
//    }
//
//    fun onSignUpClick(openAndPopUp: (String, String) -> Unit) {
//        openAndPopUp(SIGN_UP_SCREEN, SIGN_IN_SCREEN)
//    }
//}