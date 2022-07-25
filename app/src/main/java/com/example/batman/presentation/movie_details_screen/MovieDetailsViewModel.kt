package com.example.batman.presentation.movie_details_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.batman.domain.model.MovieDetails
import com.example.batman.domain.use_case.MovieDetailsUseCase
import com.example.batman.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val movieDetailsUseCase: MovieDetailsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(MovieDetailsState())
    val state:State<MovieDetailsState> get() = _state

    private val _sharedFlow = MutableSharedFlow<UiEvent>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    init {
        savedStateHandle.get<String>("imdbID")?.let { id ->
            getMovieDetails(id = id)
        }
    }

    private fun getMovieDetails(id:String){
        movieDetailsUseCase(id).onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = state.value.copy(
                        movieDetails = result.data,
                        loading = false
                    )
                }
                is Resource.Error -> {
                    _state.value = state.value.copy(
                        movieDetails = result.data,
                        loading = false
                    )
                    _sharedFlow.emit(UiEvent.ShowSnackBar(result.message?:Exception().toString()))
                }
                is Resource.Loading ->{
                    _state.value = state.value.copy(
                        loading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}

data class MovieDetailsState(
    val movieDetails:MovieDetails? = null,
    val loading:Boolean = false,
    val error:String = ""
)

sealed class UiEvent
{
    class ShowSnackBar(val error : String) : UiEvent()
}