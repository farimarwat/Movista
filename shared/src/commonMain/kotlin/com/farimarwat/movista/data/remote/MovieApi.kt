package com.farimarwat.movista.data.remote

import com.farimarwat.movista.data.model.MovieDto
import com.farimarwat.movista.data.model.SeriesDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.client.request.url
import io.ktor.http.parameters

class MovieApi(private val client: HttpClient) {
    /* curl --request GET \
     --url 'https://api.themoviedb.org/3/movie/popular?language=en-US&page=1' \
     --header 'Authorization:
     --header 'accept: application/json'*/

    suspend fun getPopularMovies(): MovieDto {
        return client.get {
           url("https://api.themoviedb.org/3/movie/popular")
            parameters {
                append("language","en-US")
                append("page","1")
            }
            headers {
                append("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5YjgwZGQ0MjE3N2FlMjVmZTg1OGEzNDNiYjJmYmRhNiIsIm5iZiI6MTc0Mjk2NjM1OS43NjgsInN1YiI6IjY3ZTM4ZTU3M2RiZTNhYjFmMmYwNGIyZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.APd4JECHic57qaX5vap5B-qGIYMzOB6OfAVRX66Wi2Q")
                append("accept","application/json")
            }
        }.body<MovieDto>()
    }
    suspend fun getTrendingMovies():MovieDto{
        return client.get {
            url("https://api.themoviedb.org/3/trending/movie/day")
            parameters {
                append("language","en-US")
            }
            headers {
                append("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5YjgwZGQ0MjE3N2FlMjVmZTg1OGEzNDNiYjJmYmRhNiIsIm5iZiI6MTc0Mjk2NjM1OS43NjgsInN1YiI6IjY3ZTM4ZTU3M2RiZTNhYjFmMmYwNGIyZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.APd4JECHic57qaX5vap5B-qGIYMzOB6OfAVRX66Wi2Q")
                append("accept","application/json")
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
            headers {
                append("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5YjgwZGQ0MjE3N2FlMjVmZTg1OGEzNDNiYjJmYmRhNiIsIm5iZiI6MTc0Mjk2NjM1OS43NjgsInN1YiI6IjY3ZTM4ZTU3M2RiZTNhYjFmMmYwNGIyZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.APd4JECHic57qaX5vap5B-qGIYMzOB6OfAVRX66Wi2Q")
                append("accept","application/json")
            }
        }.body<SeriesDto>()
    }
}