package com.farimarwat.movista.domain.repository

import com.farimarwat.movista.network.model.MovieDto

interface MovieRepository {
    suspend fun getPopularMovies():MovieDto
}