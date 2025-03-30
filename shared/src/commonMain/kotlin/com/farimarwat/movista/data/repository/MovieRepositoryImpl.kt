package com.farimarwat.movista.data.repository

import com.farimarwat.movista.domain.repository.MovieRepository
import com.farimarwat.movista.data.remote.MovieApi
import com.farimarwat.movista.data.model.MovieDto
import com.farimarwat.movista.data.model.SeriesDto

class MovieRepositoryImpl(private val api: MovieApi): MovieRepository {
    override suspend fun getPopularMovies(): MovieDto {
        return api.getPopularMovies()
    }

    override suspend fun getTrendingMovies(): MovieDto {
        return api.getTrendingMovies()
    }

    override suspend fun getTopRatedSeries(): SeriesDto {
        return api.getTopRatedSeries()
    }
}