package com.example.batman.data.remote.dto


import com.example.batman.data.local.movie_detail_entity.MovieDetailEntity
import com.example.batman.domain.model.MovieDetails
import com.google.gson.annotations.SerializedName

data class MovieDetailDto(
    @SerializedName("Actors")
    val actors: String,
    @SerializedName("Awards")
    val awards: String,
    @SerializedName("BoxOffice")
    val boxOffice: String,
    @SerializedName("Country")
    val country: String,
    @SerializedName("DVD")
    val dVD: String,
    @SerializedName("Director")
    val director: String,
    @SerializedName("Genre")
    val genre: String,
    @SerializedName("imdbID")
    val imdbID: String,
    @SerializedName("imdbRating")
    val imdbRating: String,
    @SerializedName("imdbVotes")
    val imdbVotes: String,
    @SerializedName("Language")
    val language: String,
    @SerializedName("Metascore")
    val metascore: String,
    @SerializedName("Plot")
    val plot: String,
    @SerializedName("Poster")
    val poster: String,
    @SerializedName("Production")
    val production: String,
    @SerializedName("Rated")
    val rated: String,
    @SerializedName("Ratings")
    val ratingDtos: List<RatingDto>,
    @SerializedName("Released")
    val released: String,
    @SerializedName("Response")
    val response: String,
    @SerializedName("Runtime")
    val runtime: String,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Website")
    val website: String,
    @SerializedName("Writer")
    val writer: String,
    @SerializedName("Year")
    val year: String
)

fun MovieDetailDto.toMovieDetailsEntity():MovieDetailEntity{
    return MovieDetailEntity(
        year = year,
        title = title,
        imdbID = imdbID,
        poster = poster,
        writer = writer,
        website = website,
        runtime = runtime,
        released = released,
        rated = rated,
        production = production,
        plot = plot,
        metascore = metascore,
        language = language,
        imdbVotes = imdbVotes,
        imdbRating = imdbRating,
        genre = genre,
        director = director,
        country = country,
        boxOffice = boxOffice,
        awards = awards,
        actors = actors
    )
}

fun MovieDetailDto.toMovieDetails():MovieDetails{
    return MovieDetails(
        year = year,
        title = title,
        imdbID = imdbID,
        poster = poster,
        writer = writer,
        website = website,
        runtime = runtime,
        released = released,
        rated = rated,
        production = production,
        plot = plot,
        metascore = metascore,
        language = language,
        imdbVotes = imdbVotes,
        imdbRating = imdbRating,
        genre = genre,
        director = director,
        country = country,
        boxOffice = boxOffice,
        awards = awards,
        actors = actors,
        response = response
    )
}