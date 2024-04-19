package com.stu71205.ca3_movie_booking_app.auth_login

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.stu71205.ca3_movie_booking_app.models.AuthViewModel
import okhttp3.Route

@Composable
fun MyApp(authViewModel: AuthViewModel, navController: NavHostController = rememberNavController()) {
    val loggedIn by authViewModel.loggedIn.observeAsState(initial = false)
    val context = LocalContext.current

    val currentBackStackEntry = navController.currentBackStackEntryAsState().value
    BackHandler {
        if (currentBackStackEntry == null) {
            (context as? Activity)?.finish()
        } else {
            navController.popBackStack()
        }
    }

    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val emailState = remember { mutableStateOf("") }
            val passwordState = remember { mutableStateOf("") }

            TextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Email") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = passwordState.value,
                onValueChange = { passwordState.value = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "Password") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val email = emailState.value
                    val password = passwordState.value
                    authViewModel.login(email, password)
                    if (loggedIn) {
                        navController.navigate("home_screen")
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Login")
            }
        }
    }
}
