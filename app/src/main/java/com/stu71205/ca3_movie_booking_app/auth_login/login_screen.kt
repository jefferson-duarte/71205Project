package com.stu71205.ca3_online_shopping_app.auth_user

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

//
//
//@Composable
//fun MyApp() {
//    var loggedInUserId by remember { mutableStateOf("") }
//
//    if (loggedInUserId.isEmpty()) {
//        AuthenticationScreen(onLogin = { userId -> loggedInUserId = userId })
//    } else {
////        HomeScreen(loggedInUserId = loggedInUserId, onLogout = { loggedInUserId = "" })
//    }
//}
//
//@Composable
//fun AuthenticationScreen(onLogin: (String) -> Unit) {
//    var username by remember { mutableStateOf(TextFieldValue("")) }
//    var password by remember { mutableStateOf(TextFieldValue("")) }
//
//    Column(
//        modifier = Modifier
//            .padding(16.dp)
//            .fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        TextField(
//            value = username,
//            onValueChange = { username = it },
//            label = { Text("Username") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        TextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text("Password") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(onClick = { onLogin(username.text) }) {
//            Text("Log In")
//        }
//    }
//}
