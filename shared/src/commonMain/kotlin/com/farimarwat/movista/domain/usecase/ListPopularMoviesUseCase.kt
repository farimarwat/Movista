package com.farimarwat.movista.domain.usecase

import com.farimarwat.movista.domain.repository.MovieRepository
import com.farimarwat.movista.data.model.MovieDto
import com.farimarwat.movista.domain.model.Movie

class ListPopularMoviesUseCase(private val repository: MovieRepository) {
    suspend fun execute(): List<Movie> {
        return repository.getPopularMovies()
    }
}