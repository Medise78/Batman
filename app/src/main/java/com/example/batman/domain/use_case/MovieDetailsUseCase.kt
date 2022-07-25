package com.example.batman.domain.use_case

import com.example.batman.domain.model.MovieDetails
import com.example.batman.domain.repository.MoviesRepository
import com.example.batman.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieDetailsUseCase @Inject constructor(
    private val repository: MoviesRepository
) {
    operator fun invoke(id:String):Flow<Resource<MovieDetails>>{
        if (id.isEmpty()){
            throw Exception("blank")
        }
        return repository.getMoviesDetail(id)
    }
}