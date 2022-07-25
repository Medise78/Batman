package com.example.batman.util

sealed class Screen(val route:String){
    object SplashScreen:Screen("splash_screen")
    object HomeScreen:Screen("home_screen")
    object DetailScreen:Screen("detail_screen")
}
