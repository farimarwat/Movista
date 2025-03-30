package com.farimarwat.movista.android.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farimarwat.movista.data.model.SeriesDto
import com.farimarwat.movista.domain.model.Movie
import com.farimarwat.movista.domain.model.Series
import com.farimarwat.movista.domain.usecase.ListPopularMoviesUseCase
import com.farimarwat.movista.domain.usecase.ListTopRatedSeriesUseCase
import com.farimarwat.movista.domain.usecase.ListTrendingMoviesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val listPopularMoviesUseCase: ListPopularMoviesUseCase,
    private val listTrendingMoviesUseCase: ListTrendingMoviesUseCase,
    private val listTopRatedSeriesUseCase: ListTopRatedSeriesUseCase
):ViewModel() {
    //Popular Movies
    private var _popularMovies:MutableStateFlow<List<Movie>> = MutableStateFlow(emptyList())
    val popularMovies = _popularMovies.asStateFlow()

    //Trending Movies
    private var _trendingMovies:MutableStateFlow<List<Movie>> = MutableStateFlow(emptyList())
    val trendingMovies = _trendingMovies.asStateFlow()

    //Top rated series
    private var _topRatedSeries:MutableStateFlow<List<Series>> = MutableStateFlow(emptyList())
    val topRatedSeries = _topRatedSeries.asStateFlow()

    fun fetchPopularMovies() = viewModelScope.launch (Dispatchers.IO){
        _popularMovies.value = listPopularMoviesUseCase.execute().results.map { it.toMovie() }
    }

    fun fetchTrendingMovies() = viewModelScope.launch(Dispatchers.IO) {
        _trendingMovies.value = listTrendingMoviesUseCase.execute().results.map { it.toMovie() }
    }

    fun fetchTopRatedSeries() = viewModelScope.launch(Dispatchers.IO) {
        _topRatedSeries.value = listTopRatedSeriesUseCase.execute().results.map { it.toSeries() }
    }
}