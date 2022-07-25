package com.example.batman.di

import android.app.Application
import androidx.room.Room
import com.example.batman.data.local.MovieDataBase
import com.example.batman.data.local.converter.Convertors
import com.example.batman.data.local.converter.GsonParser
import com.example.batman.data.local.converter.JsonParser
import com.example.batman.data.remote.MoviesApi
import com.example.batman.data.repository.MoviesRepositoryImpl
import com.example.batman.domain.repository.MoviesRepository
import com.example.batman.domain.use_case.MovieDetailsUseCase
import com.example.batman.domain.use_case.MoviesUseCase
import com.example.batman.util.BASE_URL
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoviesRetrofit():MoviesApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideMoviesRoom(app:Application):MovieDataBase{
        return Room.databaseBuilder(
            app,
            MovieDataBase::class.java,
            MovieDataBase.DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideMoviesRepository(api: MoviesApi , dataBase: MovieDataBase):MoviesRepository{
        return MoviesRepositoryImpl(api , dataBase.moviesDao() , dataBase.moviesDetailDao())
    }

    @Provides
    @Singleton
    fun provideMoviesUseCase(repository: MoviesRepository):MoviesUseCase{
        return MoviesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideMovieDetailsUseCase(repository: MoviesRepository):MovieDetailsUseCase{
        return MovieDetailsUseCase(repository)
    }
}