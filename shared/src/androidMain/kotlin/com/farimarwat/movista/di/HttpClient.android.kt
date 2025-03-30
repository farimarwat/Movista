package com.farimarwat.movista.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

actual val httpclient: HttpClient =
    HttpClient(OkHttp){
        install(ContentNegotiation){
            json(Json {
                ignoreUnknownKeys = true
                isLenient = true
            })
        }
        defaultRequest {
            headers {
                append("Authorization","Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5YjgwZGQ0MjE3N2FlMjVmZTg1OGEzNDNiYjJmYmRhNiIsIm5iZiI6MTc0Mjk2NjM1OS43NjgsInN1YiI6IjY3ZTM4ZTU3M2RiZTNhYjFmMmYwNGIyZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.APd4JECHic57qaX5vap5B-qGIYMzOB6OfAVRX66Wi2Q")
                append("accept","application/json")
            }
        }
    }