package com.example.batman.data.local.movie_entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.batman.domain.model.Movies

@Entity
data class MovieEntity(
    @PrimaryKey @ColumnInfo(name = "imdbID") val imdbID:String,
    @ColumnInfo(name = "poster") val poster:String,
    @ColumnInfo(name = "title") val title:String,
    @ColumnInfo(name = "type") val type:String,
    @ColumnInfo(name = "year") val year:String
)

fun MovieEntity.toMovies():Movies{
    return Movies(
        imdbID = imdbID,
        poster = poster,
        title = title,
        type = type,
        year = year
    )
}
