package com.farimarwat.movista.domain.repository

import com.farimarwat.movista.data.model.MovieDetailsDto
import com.farimarwat.movista.data.model.MovieDto
import com.farimarwat.movista.data.model.SeriesDto

interface MovieRepository {
    suspend fun getPopularMovies(): MovieDto
    suspend fun getTrendingMovies():MovieDto
    suspend fun getTopRatedSeries():SeriesDto
    suspend fun searchMovie(query:String):MovieDto
    suspend fun getMovieDetails(id:String):MovieDetailsDto
}