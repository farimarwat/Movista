package com.farimarwat.movista.domain.usecase

import com.farimarwat.movista.data.model.MovieDetailsDto
import com.farimarwat.movista.domain.repository.MovieRepository

class GetMovieDetailsUseCase(private val repository: MovieRepository) {
    suspend fun execute(id:String):MovieDetailsDto{
        return repository.getMovieDetails(id)
    }
}