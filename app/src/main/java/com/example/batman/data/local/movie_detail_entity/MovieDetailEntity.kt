package com.example.batman.data.local.movie_detail_entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.batman.domain.model.MovieDetails

@Entity
data class MovieDetailEntity(
    @ColumnInfo(name = "actors")val actors: String? = "",
    @ColumnInfo(name = "awards")val awards: String ? = "",
    @ColumnInfo(name = "boxOffice")val boxOffice: String ? = "",
    @ColumnInfo(name = "country")val country: String ? = "",
    @ColumnInfo(name = "director")val director: String ? = "",
    @ColumnInfo(name = "genre")val genre: String? = "",
    @PrimaryKey @ColumnInfo(name = "imdbID")val imdbID: String,
    @ColumnInfo(name = "imdbRating")val imdbRating: String? = "",
    @ColumnInfo(name = "imdbVotes")val imdbVotes: String ? = "",
    @ColumnInfo(name = "language")val language: String ? = "",
    @ColumnInfo(name = "metascore")val metascore: String ? = "",
    @ColumnInfo(name = "plot")val plot: String ? = "",
    @ColumnInfo(name = "poster")val poster: String ? = "",
    @ColumnInfo(name = "production")val production: String? = "",
    @ColumnInfo(name = "rated")val rated: String ? = "",
    @ColumnInfo(name = "released")val released: String? = "",
    @ColumnInfo(name = "runtime")val runtime: String ? = "",
    @ColumnInfo(name = "title")val title: String ? = "",
    @ColumnInfo(name = "website")val website: String ?= "",
    @ColumnInfo(name = "writer")val writer: String? = "",
    @ColumnInfo(name = "year")val year: String ? = ""
)

fun MovieDetailEntity.toMovieDetails():MovieDetails{
    return MovieDetails(
        year = year,
        title = title,
        poster = poster,
        imdbID = imdbID,
        actors = actors,
        awards = awards,
        boxOffice = boxOffice,
        country = country,
        director = director,
        genre = genre,
        imdbRating = imdbRating,
        imdbVotes = imdbVotes,
        language = language,
        metascore = metascore,
        plot = plot,
        production = production,
        rated = rated,
        released = released,
        response = plot,
        runtime = runtime,
        website = website,
        writer = writer
    )
}
