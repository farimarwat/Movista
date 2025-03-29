package com.farimarwat.movista.domain.repository

import com.farimarwat.movista.data.model.MovieDto

interface MovieRepository {
    suspend fun getPopularMovies(): MovieDto
}