package com.example.batman.data.remote

import com.example.batman.data.remote.dto.MovieDetailDto
import com.example.batman.data.remote.dto.MoviesDto
import com.example.batman.data.remote.dto.Search
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {
    @GET("/")
    suspend fun getMovies(
        @Query("apikey") apiKey: String = "1184f01c",
        @Query("s") s: String = "batman"
    ): MoviesDto

    @GET("/")
    suspend fun getMovieDetails(
        @Query("apikey") apiKey: String = "1184f01c",
        @Query("i") i: String
    ): MovieDetailDto
}