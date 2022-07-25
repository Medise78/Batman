package com.example.batman.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.batman.data.local.movie_detail_entity.MovieDetailEntity
import com.example.batman.data.remote.dto.MovieDetailDto

@Dao
interface MovieDetailsDao {
    @Query("SELECT * FROM MovieDetailEntity WHERE imdbID = :imdbID")
    suspend fun getMovieDetail(imdbID:String):MovieDetailEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieDetail(movieDetailDto:MovieDetailEntity)
}