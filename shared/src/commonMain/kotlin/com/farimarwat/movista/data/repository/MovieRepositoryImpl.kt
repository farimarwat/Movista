package com.farimarwat.movista.data.repository

import com.farimarwat.movista.domain.repository.MovieRepository
import com.farimarwat.movista.network.MovieApi
import com.farimarwat.movista.network.model.MovieDto

class MovieRepositoryImpl(private val api: MovieApi): MovieRepository {
    override suspend fun getPopularMovies(): MovieDto {
        return api.getPopularMovies()
    }
}