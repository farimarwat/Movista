package com.farimarwat.movista.usecase

import com.farimarwat.movista.domain.repository.MovieRepository
import com.farimarwat.movista.network.model.MovieDto

class ListPopularMoviesUseCase(private val repository: MovieRepository) {
    operator suspend fun invoke():MovieDto{
        return repository.getPopularMovies()
    }
}