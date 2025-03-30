package com.farimarwat.movista.domain.usecase

import com.farimarwat.movista.data.model.MovieDto
import com.farimarwat.movista.domain.repository.MovieRepository

class ListTrendingMoviesUseCase(private val repository: MovieRepository) {
    suspend fun execute():MovieDto{
        return repository.getTrendingMovies()
    }
}