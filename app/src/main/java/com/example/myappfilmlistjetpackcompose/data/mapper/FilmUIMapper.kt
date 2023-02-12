package com.example.myappfilmlistjetpackcompose.data.mapper

import com.example.myappfilmlistjetpackcompose.data.models.FilmResponse
import com.example.myappfilmlistjetpackcompose.domain.FilmUIData
import javax.inject.Inject

class FilmUIMapper @Inject constructor() {

    operator fun invoke(response: FilmResponse) = with(response) {
        FilmUIData(
            id = id ?: 0,
            imageUrl = imageUrl.orEmpty(),
            name = name.orEmpty(),
            trueOscar = trueOscar?: false,
            rating = rating?: 0.0,
            description = description.orEmpty()
        )
    }
}