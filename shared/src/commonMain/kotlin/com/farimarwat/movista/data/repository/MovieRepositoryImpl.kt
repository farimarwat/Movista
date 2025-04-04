package com.farimarwat.movista.data.repository

import com.farimarwat.movista.data.local.LocalDatabase
import com.farimarwat.movista.data.model.MovieDetailsDto
import com.farimarwat.movista.domain.repository.MovieRepository
import com.farimarwat.movista.data.remote.MovieApi
import com.farimarwat.movista.data.model.MovieDto
import com.farimarwat.movista.data.model.SeriesDto
import com.farimarwat.movista.domain.model.Movie

class MovieRepositoryImpl(
    private val api: MovieApi,
    private val localDb:LocalDatabase
    ): MovieRepository {
    override suspend fun getPopularMovies(): List<Movie> {
        return try {
            val movies = api.getPopularMovies().results
            val modified = movies.map { it.toMovie() }
            localDb.insertPopularMovies(modified)
             modified
        } catch (ex:Exception){
            println(ex.message)
             localDb.readAllPopularMovies()
        }
    }

    override suspend fun getTrendingMovies(): List<Movie> {
        return try {
            val movies = api.getTrendingMovies().results
            val modified = movies.map { it.toMovie() }
            localDb.insertTrendingMovies(modified)
             localDb.readAllTrendingMovies()
        }catch (ex:Exception){
            print(ex.message)
             localDb.readAllTrendingMovies()
        }
    }

    override suspend fun getTopRatedSeries(): SeriesDto? {
        return try {
             api.getTopRatedSeries()
        }catch (ex:Exception){
            print(ex)
            null
        }

    }

    override suspend fun searchMovie(query: String): MovieDto {
        return api.searchMovie(query)
    }

    override suspend fun getMovieDetails(id: String): MovieDetailsDto {
        return api.getMovieDetails(id)
    }
}