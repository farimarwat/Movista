package com.farimarwat.movista.android

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farimarwat.movista.domain.model.Movie
import com.farimarwat.movista.usecase.ListPopularMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val listPopularMoviesUseCase: ListPopularMoviesUseCase
):ViewModel() {
    private var _popularMovies:MutableStateFlow<List<Movie>> = MutableStateFlow(emptyList())
    val popularMovies = _popularMovies.asStateFlow()

    suspend fun getPopularMovies() = viewModelScope.launch (Dispatchers.IO){
        _popularMovies.value = listPopularMoviesUseCase().results.map {
            Log.i("Movie",it.title)
            it.toMovie()
        }
    }
}