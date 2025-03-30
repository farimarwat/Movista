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
    
    @Published var popularMovies:[Movie] = []
    @Published var trendingMovies:[Movie] = []
    @Published var topRatedSeries:[Series] = []
    
    init(){
        listPopularMoviesUseCase = UseCaseProvider.shared.getListPopularMoviesUseCase()
        listTrendingMoviesUseCase = UseCaseProvider.shared.getListTrendingMoviesUseCase()
        listTopRatedSeriesUseCase = UseCaseProvider.shared.getListTopRatedSeriesUseCase()
    }
    
    @MainActor
    func fetchPopularMovies() async {
        do {
            let movies = try await listPopularMoviesUseCase.execute().results.map{ item in
                item.toMovie()
            }
            popularMovies = movies
        } catch let error {
            print(error)
        }
    }
    
    @MainActor
    func fetchTrendingMovies() async{
        do {
            let movies =  try await listTrendingMoviesUseCase.execute().results.map { item in
                item.toMovie()
            }
            trendingMovies = movies
        } catch let error {
            print(error)
        }
    }
    
    @MainActor
    func fetchTopRatedSeries() async{
        do {
            let series = try await listTopRatedSeriesUseCase.execute().results.map { item in
                item.toSeries()
            }
            topRatedSeries = series
        } catch let error {
            print(error)
        }
    }
    
}
