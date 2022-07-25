package com.example.batman.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.batman.presentation.movie_details_screen.MovieDetailsScreen
import com.example.batman.presentation.movies_screen.MoviesScreen
import com.example.batman.presentation.splash_screen.SplashScreen
import com.example.batman.util.Screen

@Composable
fun Navigation(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = Screen.SplashScreen.route){

        composable(Screen.SplashScreen.route){
            SplashScreen(navController = navHostController)
        }

        composable(Screen.HomeScreen.route){
            MoviesScreen(navController = navHostController)
        }
        composable(Screen.DetailScreen.route + "/{imdbID}" , arguments = listOf(
            navArgument("imdbID"){
                type = NavType.StringType
            }
        )){
            MovieDetailsScreen(navController = navHostController)
        }
    }
}