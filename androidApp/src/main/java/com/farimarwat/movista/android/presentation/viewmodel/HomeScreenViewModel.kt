package com.farimarwat.movista.android.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.farimarwat.movista.domain.usecase.ListPopularMoviesUseCase

class HomeScreenViewModel(
    private val listPopularMoviesUseCase: ListPopularMoviesUseCase
):ViewModel() {
}