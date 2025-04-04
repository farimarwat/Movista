package com.farimarwat.movista.domain.repository

import com.farimarwat.movista.data.model.MovieDetailsDto
import com.farimarwat.movista.data.model.MovieDto
import com.farimarwat.movista.data.model.SeriesDto
import com.farimarwat.movista.domain.model.Movie

interface MovieRepository {
    suspend fun getPopularMovies(): List<Movie>
    suspend fun getTrendingMovies():List<Movie>
    suspend fun getTopRatedSeries():SeriesDto?
    suspend fun searchMovie(query:String):MovieDto
    suspend fun getMovieDetails(id:String):MovieDetailsDto
}