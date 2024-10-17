package com.example.myapplication

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.myapplication.data.db.MenuDatabase
import com.example.myapplication.data.db.MenuItemRoom
import com.example.myapplication.data.network.MenuItemNetwork
import com.example.myapplication.data.network.MenuNetwork
import com.example.myapplication.ui.theme.MyApplicationTheme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    private val httpClient = HttpClient(Android) {
        install(ContentNegotiation) {
            json(contentType = ContentType("text", "plain"))
        }
    }

    private val database by lazy {
        Room.databaseBuilder(applicationContext, MenuDatabase::class.java, "menu_table")
            .fallbackToDestructiveMigration()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences("User", MODE_PRIVATE)

        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val databaseMenuItems = database.menuDao().getAll().observeAsState(initial = emptyList())
                    Greeting(databaseMenuItems.value)
                    //val contentNegotiation: ContentNegotiation
                }
            }
        }
        lifecycleScope.launch(Dispatchers.IO) {
            if (database.menuDao().isEmpty()) {
                val res = fetchMenu()
                saveMenuToDatabase(res)
            }
        }
    }

    private suspend fun fetchMenu(): List<MenuItemNetwork> {
        return httpClient
            .get("https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json")
            .body<MenuNetwork>()
            .menu
    }

    private fun saveMenuToDatabase(menuItemsNetwork: List<MenuItemNetwork>) {
        val menuItemsRoom = menuItemsNetwork.map { it.toMenuItemRoom() }
        database.menuDao().insertAll(*menuItemsRoom.toTypedArray())
    }

    @Composable
    fun Greeting(databaseMenuItems: List<MenuItemRoom>) {
        val navController = rememberNavController()
        val registered = sharedPreferences.getBoolean("registered", false)
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
                HomeScreen(
                    menuItems = databaseMenuItems,
                    onClick = { navController.navigate(Profile.route) }
                )
            }
            composable(Profile.route) {
                Profile(onClick = {
                    sharedPreferences.edit().putBoolean("registered", false).apply()
                    navController.navigate(Onboarding.route)
                })
            }
        }
    }

    private fun navToHome(firstName: String, lastName: String, email: String, navController: NavController){
        val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
        if(firstName.isNotEmpty() && lastName.isNotEmpty() && emailRegex.matches(email)){
            navController.navigate(HomeScreen.route)
            sharedPreferences.edit().putBoolean("registered", true).apply()
        }else{
            Log.d("TAG", "Invalid: ")
        }
    }
}
