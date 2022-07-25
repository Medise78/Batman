package com.example.batman.presentation.movies_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.batman.domain.model.Movies
import com.example.batman.domain.use_case.MoviesUseCase
import com.example.batman.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val moviesUseCase: MoviesUseCase
):ViewModel() {
    private val _state = mutableStateOf(MoviesState())
    val state:State<MoviesState> get() = _state

    private val _sharedFlow = MutableSharedFlow<UiEvent>()
    val sharedFlow = _sharedFlow.asSharedFlow()

    init {
        getMovies()
    }

    private fun getMovies(){
        viewModelScope.launch {
            moviesUseCase().onEach { result ->
                when(result){
                    is Resource.Success -> {
                        _state.value = state.value.copy(
                            movies = result.data?: emptyList(),
                            loading = false
                        )
                    }
                    is Resource.Error ->{
                        _state.value = state.value.copy(
                            movies = result.data?: emptyList(),
                            loading = false
                        )
                        _sharedFlow.emit(UiEvent.ShowSnackBar(result.message?:""))
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
}

data class MoviesState(
    val movies:List<Movies> = emptyList(),
    val loading:Boolean = false,
    val error:String = ""
)

sealed class UiEvent{
    class ShowSnackBar(val error:String):UiEvent()
}