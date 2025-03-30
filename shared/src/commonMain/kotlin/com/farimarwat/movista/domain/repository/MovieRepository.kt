package com.farimarwat.movista.domain.repository

import com.farimarwat.movista.data.model.MovieDto
import com.farimarwat.movista.data.model.SeriesDto

interface MovieRepository {
    suspend fun getPopularMovies(): MovieDto
    suspend fun getTrendingMovies():MovieDto
    suspend fun getTopRatedSeries():SeriesDto
}