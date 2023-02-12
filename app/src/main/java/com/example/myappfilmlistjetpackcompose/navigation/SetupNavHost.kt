package com.example.myappfilmlistjetpackcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myappfilmlistjetpackcompose.FilmViewModel
import com.example.myappfilmlistjetpackcompose.screens.FilmDescriptionScreen
import com.example.myappfilmlistjetpackcompose.screens.FilmListScreen
import com.example.myappfilmlistjetpackcompose.utils.Constants

sealed class Screens(val route: String) {
    object FilmList: Screens(route = Constants.Screens.FILM_LIST_SCREEN)
    object FilmDescription: Screens(route = Constants.Screens.FILM_DESCRIPTION_SCREEN)
}

@Composable
fun SetupNavHost (navController: NavHostController, viewModel: FilmViewModel){
    NavHost(navController = navController,
        startDestination = Screens.FilmList.route
    ) {
        composable(route = Screens.FilmList.route) {
            FilmListScreen(navController = navController, viewModel = viewModel)
        }
        composable(route = Screens.FilmDescription.route + "/{Id}") {backStackEntry ->
            FilmDescriptionScreen(viewModel = viewModel, filmId = backStackEntry.arguments?.getString("id")?:"1")
        }
    }
}