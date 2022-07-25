package com.example.batman.data.remote.dto


import com.example.batman.domain.model.Rating
import com.google.gson.annotations.SerializedName

data class RatingDto(
    @SerializedName("Source")
    val source: String,
    @SerializedName("Value")
    val value: String
)
fun RatingDto.toRating():Rating{
    return Rating(
        source = source,
        value = value
    )
}