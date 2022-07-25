package com.example.batman.data.remote.dto


import com.example.batman.data.local.movie_entity.MovieEntity
import com.google.gson.annotations.SerializedName

data class Search(
    @SerializedName("imdbID")
    val imdbID: String,
    @SerializedName("Poster")
    val poster: String,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Type")
    val type: String,
    @SerializedName("Year")
    val year: String
)
