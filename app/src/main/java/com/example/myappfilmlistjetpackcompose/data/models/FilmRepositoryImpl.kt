package com.example.myappfilmlistjetpackcompose.data.models

import com.example.myappfilmlistjetpackcompose.data.Server
import com.example.myappfilmlistjetpackcompose.data.mapper.FilmUIMapper
import com.example.myappfilmlistjetpackcompose.domain.FilmRepository
import com.example.myappfilmlistjetpackcompose.domain.FilmUIData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val server: Server,
    private val mapper: FilmUIMapper
) : FilmRepository {

    override suspend fun getFilms(): List<FilmUIData> = withContext(Dispatchers.IO) {server.getFilms().map { mapper(it) }}
}