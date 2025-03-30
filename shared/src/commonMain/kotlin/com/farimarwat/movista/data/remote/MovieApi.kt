package com.farimarwat.movista.data.remote

import com.farimarwat.movista.data.model.MovieDto
import com.farimarwat.movista.data.model.SeriesDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.url
import io.ktor.http.parameters
import io.ktor.http.takeFrom

class MovieApi(private val client: HttpClient) {

    suspend fun getPopularMovies(): MovieDto {
        return client.get {
           url("https://api.themoviedb.org/3/movie/popular")
            parameters {
                append("language","en-US")
                append("page","1")
            }
        }.body<MovieDto>()
    }
    suspend fun getTrendingMovies():MovieDto{
        return client.get {
            url("https://api.themoviedb.org/3/trending/movie/day")
            parameters {
                append("language","en-US")
            }
        }.body<MovieDto>()
    }

    suspend fun getTopRatedSeries():SeriesDto{
        return client.get {
            url("https://api.themoviedb.org/3/tv/top_rated")
            parameters {
                append("language","en-US")
                append("page","1")
            }
        }.body<SeriesDto>()
    }

    suspend fun searchMovie(query:String):MovieDto{
       return client.get {
           url {
               takeFrom("https://api.themoviedb.org/3/search/movie")
               encodedParameters.append("query", query)
               encodedParameters.append("include_adult", "false")
               encodedParameters.append("language", "en-US")
               encodedParameters.append("page", "1")
           }
        }.body<MovieDto>()
    }
}