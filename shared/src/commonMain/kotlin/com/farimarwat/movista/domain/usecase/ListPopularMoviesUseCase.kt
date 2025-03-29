package com.farimarwat.movista.domain.usecase

import com.farimarwat.movista.domain.repository.MovieRepository
import com.farimarwat.movista.network.model.MovieDto

class ListPopularMoviesUseCase(private val repository: MovieRepository) {
    suspend fun execute():MovieDto{
        return repository.getPopularMovies()
    }
}