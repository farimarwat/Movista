package com.farimarwat.movista.data.repository

import com.farimarwat.movista.domain.repository.MovieRepository
import com.farimarwat.movista.data.remote.MovieApi
import com.farimarwat.movista.data.model.MovieDto

class MovieRepositoryImpl(private val api: MovieApi): MovieRepository {
    override suspend fun getPopularMovies(): MovieDto {
        return api.getPopularMovies()
    }
}