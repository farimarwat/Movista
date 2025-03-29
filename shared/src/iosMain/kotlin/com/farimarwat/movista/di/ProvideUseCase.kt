package com.farimarwat.movista.di

import com.farimarwat.movista.domain.usecase.ListPopularMoviesUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

object ProvideUseCase: KoinComponent {
    fun getListPopularMoviesUseCase(): ListPopularMoviesUseCase = get()
}