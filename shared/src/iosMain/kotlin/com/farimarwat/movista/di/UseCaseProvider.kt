package com.farimarwat.movista.di

import com.farimarwat.movista.data.model.MovieDto
import com.farimarwat.movista.domain.usecase.GetMovieDetailsUseCase
import com.farimarwat.movista.domain.usecase.ListPopularMoviesUseCase
import com.farimarwat.movista.domain.usecase.ListTopRatedSeriesUseCase
import com.farimarwat.movista.domain.usecase.ListTrendingMoviesUseCase
import com.farimarwat.movista.domain.usecase.SearchMovieUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

object UseCaseProvider: KoinComponent {
    fun getListPopularMoviesUseCase(): ListPopularMoviesUseCase = get()
    fun getListTrendingMoviesUseCase(): ListTrendingMoviesUseCase = get()
    fun getListTopRatedSeriesUseCase():ListTopRatedSeriesUseCase = get()
    fun getSearchMovieUseCase():SearchMovieUseCase = get()
    fun getGetMoviesDetailsUseCase():GetMovieDetailsUseCase = get()
}