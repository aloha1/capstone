package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlin.coroutines.coroutineContext

class MainActivity : ComponentActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        sharedPreferences = getSharedPreferences("User", MODE_PRIVATE)
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(sharedPreferences)
                }
            }
        }
    }

    @Composable
    fun Greeting(sharedPreferences: SharedPreferences) {
        var registered = sharedPreferences.getBoolean("registered", false)
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
                //onClick = { navController.navigate(HomeScreen.route)})
            }
            composable(HomeScreen.route){
                HomeScreen(onClick = { navController.navigate(Profile.route)})
            }
            composable(Profile.route) {
                Profile(onClick = { navController.navigate(Onboarding.route)})
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
//
//@Composable
//fun Greeting(sharedPreferences: SharedPreferences) {
//    var registered = sharedPreferences.getBoolean("registered", false)
//    val navController = rememberNavController()
//    val startDestination = if(registered){
//        HomeScreen.route
//    }else{
//        Onboarding.route
//    }
//    NavHost(navController = navController, startDestination = startDestination){
//        composable(Onboarding.route){
//            Onboarding(onClick = this::NavToHome)
//                //onClick = { navController.navigate(HomeScreen.route)})
//        }
//        composable(HomeScreen.route){
//            HomeScreen(onClick = { navController.navigate(Profile.route)})
//        }
//        composable(Profile.route) {
//            Profile(onClick = { navController.navigate(Onboarding.route)})
//        }
//    }
//}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    MyApplicationTheme {
//        Greeting()
//    }
//}