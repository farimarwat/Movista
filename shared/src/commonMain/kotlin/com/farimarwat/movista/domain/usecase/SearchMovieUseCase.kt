package com.farimarwat.movista.domain.usecase

import com.farimarwat.movista.data.model.MovieDto
import com.farimarwat.movista.domain.repository.MovieRepository

class SearchMovieUseCase(private val repository: MovieRepository) {
    suspend fun execute(query:String):MovieDto{
        return repository.searchMovie(query)
    }
}