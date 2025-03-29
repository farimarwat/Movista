package com.farimarwat.movista.di

import com.farimarwat.movista.data.repository.MovieRepositoryImpl
import com.farimarwat.movista.domain.repository.MovieRepository
import com.farimarwat.movista.network.MovieApi
import com.farimarwat.movista.domain.usecase.ListPopularMoviesUseCase
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val sharedModule = module {
    singleOf(::httpclient)
    singleOf(::MovieApi)
    singleOf(::MovieRepositoryImpl).bind<MovieRepository>()
    singleOf(::ListPopularMoviesUseCase)
}

fun initKoin(){
    startKoin {
        modules(sharedModule)
    }
}