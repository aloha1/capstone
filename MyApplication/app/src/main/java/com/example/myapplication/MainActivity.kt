package com.example.myapplication

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.ui.theme.MyApplicationTheme

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
    NavHost(navController = navController, startDestination = startDestination){
        composable(Onboarding.route){
            Onboarding()
        }
        composable(HomeScreen.route){
            //HomeScreen()
        }
        composable(Profile.route + "/{${Profile.argDishId}}",
            arguments = listOf(navArgument(Profile.argDishId) { type = NavType.IntType })
        ) {
            val id = requireNotNull(it.arguments?.getInt(Profile.argDishId)) { "Dish id is null" }
            //Profile(id)
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