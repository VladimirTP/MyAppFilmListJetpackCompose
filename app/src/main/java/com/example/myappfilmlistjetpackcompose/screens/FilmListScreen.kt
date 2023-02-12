package com.example.myappfilmlistjetpackcompose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.myappfilmlistjetpackcompose.FilmViewModel
import com.example.myappfilmlistjetpackcompose.domain.FilmUIData
import com.example.myappfilmlistjetpackcompose.navigation.Screens

@Composable
fun FilmListScreen (navController: NavController, viewModel: FilmViewModel) {
    viewModel.getFilms()
    val filmList = viewModel.filmLiveData.observeAsState(listOf()).value
    Surface (
        modifier = Modifier
            .fillMaxSize()
            ) {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(
                items = filmList,
                itemContent = {film->
                    FilmListItem(film = film, navController = navController)
                }
            )
        }
    }
}

@Composable
fun FilmListItem(film: FilmUIData, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row(
            Modifier.clickable {
                navController.navigate(Screens.FilmDescription.route + "/${film.id}")
            }
        ) {
            FilmImage(film = film)
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = film.name, style = MaterialTheme.typography.h6)
                Text(text = film.rating.toString(), style = MaterialTheme.typography.h6)
                Text(text = "VIEW DETAIL", style = MaterialTheme.typography.caption)
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FilmImage(film: FilmUIData) {
    GlideImage(
        model = film.imageUrl,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}
