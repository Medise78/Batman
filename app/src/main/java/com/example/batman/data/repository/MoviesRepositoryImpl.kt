package com.example.batman.data.repository

import com.example.batman.data.local.MovieDetailsDao
import com.example.batman.data.local.MoviesDao
import com.example.batman.data.local.movie_detail_entity.toMovieDetails
import com.example.batman.data.local.movie_entity.toMovies
import com.example.batman.data.remote.MoviesApi
import com.example.batman.data.remote.dto.toMovieDetailsEntity
import com.example.batman.data.remote.dto.toMoviesEntity
import com.example.batman.domain.model.MovieDetails
import com.example.batman.domain.model.Movies
import com.example.batman.domain.repository.MoviesRepository
import com.example.batman.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesApi: MoviesApi,
    private val moviesDao: MoviesDao,
    private val movieDetailsDao: MovieDetailsDao
) : MoviesRepository {
    override fun getMovies(): Flow<Resource<List<Movies>>> = flow {
        emit(Resource.Loading())
        val getMovies = moviesDao.getMovies().map { it.toMovies() }
        emit(Resource.Loading())

        try {
            val getMoviesDto = moviesApi.getMovies()
            moviesDao.insertMovie(getMoviesDto.toMoviesEntity())
            val getMoviesDao = moviesDao.getMovies().map { it.toMovies() }
            emit(Resource.Success(getMoviesDao))
        } catch (e: HttpException) {
            emit(Resource.Error(data = getMovies, e.message()))
        } catch (e: IOException) {
            emit(Resource.Error(data = getMovies, e.message.toString()))
        } catch (e: Exception) {
            emit(Resource.Error(getMovies, e.message.toString()))
        }
    }

    override fun getMoviesDetail(imdbID: String): Flow<Resource<MovieDetails>> = flow {
        emit(Resource.Loading())
        val getMoviesDetail = movieDetailsDao.getMovieDetail(imdbID)?.toMovieDetails()
        emit(Resource.Loading())
        try {
            val getMovieDetailsDto = moviesApi.getMovieDetails(i = imdbID)
            movieDetailsDao.insertMovieDetail(getMovieDetailsDto.toMovieDetailsEntity())
            val getMovieDetailsDao = movieDetailsDao.getMovieDetail(imdbID)!!.toMovieDetails()
            emit(Resource.Success(getMovieDetailsDao))
        } catch (e: HttpException) {
            emit(Resource.Error(getMoviesDetail, e.message.toString()))
        } catch (e: IOException) {
            emit(Resource.Error(getMoviesDetail, e.message.toString()))
        } catch (e: Exception) {
            emit(Resource.Error(getMoviesDetail, e.message.toString()))
        }
    }
}