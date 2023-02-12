package com.example.myappfilmlistjetpackcompose.di

import com.example.myappfilmlistjetpackcompose.data.models.FilmRepositoryImpl
import com.example.myappfilmlistjetpackcompose.domain.FilmRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule() {

    @Binds
    abstract fun getFilms(impl: FilmRepositoryImpl): FilmRepository
}