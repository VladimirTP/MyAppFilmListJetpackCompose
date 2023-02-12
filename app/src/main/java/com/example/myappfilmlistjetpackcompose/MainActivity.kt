package com.example.myappfilmlistjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.example.myappfilmlistjetpackcompose.navigation.SetupNavHost
import com.example.myappfilmlistjetpackcompose.screens.FilmListScreen
import com.example.myappfilmlistjetpackcompose.ui.theme.FilmTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FilmTheme {
                val navController = rememberNavController()
                val viewModel = hiltViewModel<FilmViewModel>()
                SetupNavHost(navController = navController, viewModel = viewModel)
                FilmListScreen(navController,viewModel)
            }
        }
    }
}