package com.example.batman.domain.model

import com.google.gson.annotations.SerializedName

data class Movies(
    val imdbID: String?,
    val poster: String?,
    val title: String?,
    val type: String?,
    val year: String?
)
