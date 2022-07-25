package com.example.batman.data.remote.dto


import com.example.batman.data.local.movie_entity.MovieEntity
import com.google.gson.annotations.SerializedName

data class MoviesDto(
    @SerializedName("Search")
    val search: List<Search>,
)

fun MoviesDto.toMoviesEntity(): List<MovieEntity> = search.map {
    MovieEntity(
        title = it.title,
        poster = it.poster,
        imdbID = it.imdbID,
        year = it.year,
        type = it.type
    )
}