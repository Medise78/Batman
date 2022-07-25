package com.example.batman.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.batman.data.local.movie_entity.MovieEntity

@Dao
interface MoviesDao {
    @Query("SELECT * FROM movieentity")
    suspend fun getMovies():List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(movieDtos:List<MovieEntity>)
}