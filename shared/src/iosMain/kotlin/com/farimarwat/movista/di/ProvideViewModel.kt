package com.farimarwat.movista.di

import com.farimarwat.movista.usecase.ListPopularMoviesUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

object ProvideUseCases: KoinComponent {
    fun getListPopularMoviesUseCase():ListPopularMoviesUseCase = get()
}