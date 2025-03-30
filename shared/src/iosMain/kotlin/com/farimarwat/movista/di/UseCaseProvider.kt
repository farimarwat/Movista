package com.farimarwat.movista.di

import com.farimarwat.movista.domain.usecase.ListPopularMoviesUseCase
import com.farimarwat.movista.domain.usecase.ListTrendingMoviesUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

object UseCaseProvider: KoinComponent {
    fun getListPopularMoviesUseCase(): ListPopularMoviesUseCase = get()
    fun getListTrendingMoviesUseCase(): ListTrendingMoviesUseCase = get()
}