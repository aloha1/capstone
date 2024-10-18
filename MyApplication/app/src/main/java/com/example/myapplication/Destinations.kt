package com.example.myapplication

interface Destinations {
    val route: String
}

object Onboarding : Destinations {
    override val route = "Onboarding"
}

object HomeScreen : Destinations {
    override val route = "HomeScreen"
}

object Profile : Destinations {
    override val route = "Profile"
}
