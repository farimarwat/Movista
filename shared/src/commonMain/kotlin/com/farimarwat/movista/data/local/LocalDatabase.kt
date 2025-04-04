package com.farimarwat.movista.data.local

import app.cash.sqldelight.db.SqlDriver
import com.farimarwat.movista.domain.model.Movie
import com.movista.MovistaDatabase
import kotlinx.coroutines.flow.asFlow

class LocalDatabase(
    driver: SqlDriver
) {
    private val database = MovistaDatabase(driver)
    private val trendingMovies = database.trendingMovieQueries
    private val popularMovies = database.popularMovieQueries

    //Trending Movies
    fun readAllTrendingMovies(): List<Movie> {
        return trendingMovies.readAllMovies()
            .executeAsList()
            .map {
                Movie(
                    adult = it.adult.toInt() == 1,
                    backdropPath = it.backdropPath,
                    genreIds = listOf(0, 1),
                    id = it.id,
                    originalLanguage = it.originalLanguage,
                    originalTitle = it.originalTitle,
                    overview = it.overview,
                    popularity = it.popularity,
                    posterPath = it.posterPath,
                    releaseDate = it.releaseDate,
                    title = it.title,
                    video = it.video.toInt() == 1,
                    voteAverage = it.voteAverage,
                    voteCount = it.voteCount
                )
            }
    }

    fun insertTrendingMovies(movies: List<Movie>) {
        try{
            trendingMovies.transaction {
                movies.forEach { movie ->
                    trendingMovies.insertMovie(
                        id = movie.id,
                        adult = if (movie.adult) 1 else 0,
                        backdropPath = movie.backdropPath,
                        originalLanguage = movie.originalLanguage,
                        originalTitle = movie.originalTitle,
                        overview = movie.overview,
                        popularity = movie.popularity,
                        posterPath = movie.posterPath,
                        releaseDate = movie.releaseDate,
                        title = movie.title,
                        video = if (movie.video) 1 else 0,
                        voteAverage = movie.voteAverage,
                        voteCount = movie.voteCount
                    )
                }
            }
        }catch (ex:Exception){
            print(ex)
        }
    }

    //Popular Movies
    fun readAllPopularMovies(): List<Movie> {
        return popularMovies.readAllMovies()
            .executeAsList()
            .map {
                Movie(
                    adult = it.adult.toInt() == 1,
                    backdropPath = it.backdropPath,
                    genreIds = listOf(0, 1),
                    id = it.id,
                    originalLanguage = it.originalLanguage,
                    originalTitle = it.originalTitle,
                    overview = it.overview,
                    popularity = it.popularity,
                    posterPath = it.posterPath,
                    releaseDate = it.releaseDate,
                    title = it.title,
                    video = it.video.toInt() == 1,
                    voteAverage = it.voteAverage,
                    voteCount = it.voteCount
                )
            }
    }

    fun insertPopularMovies(movies: List<Movie>) {
       try{
           popularMovies.transaction {
               movies.forEach { movie ->
                   popularMovies.insertMovie(
                       id = movie.id,
                       adult = if (movie.adult) 1 else 0,
                       backdropPath = movie.backdropPath,
                       originalLanguage = movie.originalLanguage,
                       originalTitle = movie.originalTitle,
                       overview = movie.overview,
                       popularity = movie.popularity,
                       posterPath = movie.posterPath,
                       releaseDate = movie.releaseDate,
                       title = movie.title,
                       video = if (movie.video) 1 else 0,
                       voteAverage = movie.voteAverage,
                       voteCount = movie.voteCount
                   )
               }
           }
       }catch (ex:Exception){
           print(ex)
       }
    }
}