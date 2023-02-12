package com.example.myappfilmlistjetpackcompose.domain

data class FilmUIData(
    val id: Int,
    val imageUrl: String,
    val name: String,
    val trueOscar: Boolean,
    val rating: Double,
    val description: String
)