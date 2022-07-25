package com.example.batman.domain.repository

import com.example.batman.domain.model.MovieDetails
import com.example.batman.domain.model.Movies
import com.example.batman.util.Resource
import kotlinx.coroutines.flow.Flow

interface MoviesRepository {
    fun getMovies():Flow<Resource<List<Movies>>>
    fun getMoviesDetail(id:String):Flow<Resource<MovieDetails>>
}