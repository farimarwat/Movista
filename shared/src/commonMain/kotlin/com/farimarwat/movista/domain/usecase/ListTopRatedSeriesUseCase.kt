package com.farimarwat.movista.domain.usecase

import com.farimarwat.movista.data.model.MovieDto
import com.farimarwat.movista.data.model.SeriesDto
import com.farimarwat.movista.domain.repository.MovieRepository

class ListTopRatedSeriesUseCase(private val repository: MovieRepository) {
    suspend fun execute():SeriesDto?{
        return repository.getTopRatedSeries()
    }
}