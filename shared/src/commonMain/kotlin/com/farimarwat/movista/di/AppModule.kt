package com.farimarwat.movista.di

import com.farimarwat.movista.data.local.LocalDatabase
import com.farimarwat.movista.data.repository.MovieRepositoryImpl
import com.farimarwat.movista.domain.repository.MovieRepository
import com.farimarwat.movista.data.remote.MovieApi
import com.farimarwat.movista.domain.usecase.GetMovieDetailsUseCase
import com.farimarwat.movista.domain.usecase.ListPopularMoviesUseCase
import com.farimarwat.movista.domain.usecase.ListTopRatedSeriesUseCase
import com.farimarwat.movista.domain.usecase.ListTrendingMoviesUseCase
import com.farimarwat.movista.domain.usecase.SearchMovieUseCase
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val sharedModule = module {
    singleOf(::httpclient)
    singleOf(::MovieApi)
    singleOf(::LocalDatabase)
    singleOf(::MovieRepositoryImpl).bind<MovieRepository>()
    singleOf(::ListPopularMoviesUseCase)
    singleOf(::ListTrendingMoviesUseCase)
    singleOf(::ListTopRatedSeriesUseCase)
    singleOf(::SearchMovieUseCase)
    singleOf(::GetMovieDetailsUseCase)
}

expect val platformModule:Module

fun initKoin(){
    startKoin {
        modules(sharedModule + platformModule)
    }
}