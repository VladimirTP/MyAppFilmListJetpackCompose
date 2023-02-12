package com.example.myappfilmlistjetpackcompose.domain

interface FilmRepository {
    suspend fun getFilms (): List<FilmUIData>
}