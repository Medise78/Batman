package com.example.batman.domain.use_case

import com.example.batman.domain.model.Movies
import com.example.batman.domain.repository.MoviesRepository
import com.example.batman.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
) {
    operator fun invoke():Flow<Resource<List<Movies>>>{
        return repository.getMovies()
    }
}