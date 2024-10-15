package com.example.myapplication

interface Destinations {
    val route: String
}

object Onboarding : Destinations {
    override val route = "Onboarding"
}

object HomeScreen : Destinations {
    override val route = "HomeScreen"
    const val argDishId = "dishId"
}

object Profile : Destinations {
    override val route = "Profile"
    const val argDishId = "dishId"
}
