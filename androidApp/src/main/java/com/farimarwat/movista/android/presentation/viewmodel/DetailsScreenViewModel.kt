package com.farimarwat.movista.android.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.farimarwat.movista.data.model.MovieDetailsDto
import com.farimarwat.movista.domain.usecase.GetMovieDetailsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailsScreenViewModel(
    private val getMoviesDetailsUseCase: GetMovieDetailsUseCase
):ViewModel() {
    private var _movieDetails:MutableStateFlow<MovieDetailsDto?> = MutableStateFlow(null)
    val movieDetails = _movieDetails.asStateFlow()

     fun fetchMovieDetails(id:String) = viewModelScope.launch(Dispatchers.IO) {
        _movieDetails.value = getMoviesDetailsUseCase.execute(id)
    }
}