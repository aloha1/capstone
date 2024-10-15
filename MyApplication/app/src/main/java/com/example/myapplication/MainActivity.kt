package com.example.myapplication

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation

class MainActivity : ComponentActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    //private lateinit var httpClient: HttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("User", MODE_PRIVATE)
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(sharedPreferences)
                    //val contentNegotiation: ContentNegotiation
                }
            }
        }
    }

    @Composable
    fun Greeting(sharedPreferences: SharedPreferences) {
        val registered = sharedPreferences.getBoolean("registered", false)
        val navController = rememberNavController()
        val startDestination = if(registered){
            HomeScreen.route
        }else{
            Onboarding.route
        }
        val onClick = this::navToHome
        NavHost(navController = navController, startDestination = startDestination){
            composable(Onboarding.route){
                Onboarding(navController = navController, onClick = onClick)
            }
            composable(HomeScreen.route){
                HomeScreen(onClick = { navController.navigate(Profile.route) })
            }
            composable(Profile.route) {
                Profile(onClick = { navController.navigate(Onboarding.route) })
            }
        }
    }

    private fun navToHome(firstName: String, lastName: String, email: String, navController: NavController){
        val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
        if(firstName.isNotEmpty() && lastName.isNotEmpty() && emailRegex.matches(email)){
            navController.navigate(HomeScreen.route)
        }else{
            Log.d("TAG", "navToHome: ")
        }

    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyApplicationTheme {
//        Greeting()
//    }
//}