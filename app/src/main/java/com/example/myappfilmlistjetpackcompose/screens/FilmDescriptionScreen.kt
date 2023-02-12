package com.example.myappfilmlistjetpackcompose.screens
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.myappfilmlistjetpackcompose.FilmViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun FilmDescriptionScreen (viewModel: FilmViewModel, filmId: String) {
    val currentItem = viewModel.filmLiveData
        .observeAsState(listOf()).value
        .firstOrNull{it.id == filmId.toInt()}

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 24.dp, horizontal = 8.dp)
    ) {
        LazyColumn {
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    GlideImage(
                        model = currentItem?.imageUrl,
                        contentDescription = null,
                        modifier = Modifier.size(500.dp)
                    )
                    Text(
                        text = currentItem?.name?:"",
                        fontWeight = FontWeight.Bold,
                        fontSize = 32.sp,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                    Row(
                        modifier = Modifier.padding(top = 8.dp)
                    ) {
                        Text(
                            text = "Rating: ",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        Text(
                            text = currentItem?.rating.toString(),
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}