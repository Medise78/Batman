package com.example.batman.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.batman.data.local.converter.Convertors
import com.example.batman.data.local.movie_detail_entity.MovieDetailEntity
import com.example.batman.data.local.movie_entity.MovieEntity


@Database(
    entities = [MovieEntity::class, MovieDetailEntity::class],
    version = 1,
    exportSchema = false
)
abstract class MovieDataBase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
    abstract fun moviesDetailDao(): MovieDetailsDao

    companion object {
        const val DB_NAME = "MOVIES_DB"
    }
}
