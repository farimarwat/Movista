//
//  HomeViewModel.swift
//  iosApp
//
//  Created by mac on 29/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import shared

class HomeViewModel:ObservableObject{
    //UseCases
    var listPopularMoviesUseCase:ListPopularMoviesUseCase
    var listTrendingMoviesUseCase:ListTrendingMoviesUseCase
    var listTopRatedSeriesUseCase:ListTopRatedSeriesUseCase
    var searchMovieUseCase:SearchMovieUseCase
    
    @Published var popularMovies:[Movie] = []
    @Published var trendingMovies:[Movie] = []
    @Published var topRatedSeries:[Series] = []
    @Published var searchedMovies:[Movie] = []
    
    init(){
        listPopularMoviesUseCase = UseCaseProvider.shared.getListPopularMoviesUseCase()
        listTrendingMoviesUseCase = UseCaseProvider.shared.getListTrendingMoviesUseCase()
        listTopRatedSeriesUseCase = UseCaseProvider.shared.getListTopRatedSeriesUseCase()
        searchMovieUseCase = UseCaseProvider.shared.getSearchMovieUseCase()
    }
    
    @MainActor
    func fetchPopularMovies() async {
        do {
            let movies = try await listPopularMoviesUseCase.execute()
            popularMovies = movies
        } catch let error {
            print(error)
        }
    }
    
    @MainActor
    func fetchTrendingMovies() async{
        do {
            let movies =  try await listTrendingMoviesUseCase.execute()
            trendingMovies = movies
        } catch let error {
            print(error)
        }
    }
    
    @MainActor
    func fetchTopRatedSeries() async{
        do {
            if let series = try await listTopRatedSeriesUseCase.execute()?.results {
                let mapped = series.map{item in
                    item.toSeries()
                }
                topRatedSeries = mapped
            }
            
        } catch let error {
            print(error)
        }
    }
    
    @MainActor
    func fetchSearchMovies(query:String) async{
        do {
            let movies = try await searchMovieUseCase.execute(query: query).results.map { item in
                item.toMovie()
            }
            searchedMovies = movies
        } catch let error {
            print(error)
        }
    }
    
}
