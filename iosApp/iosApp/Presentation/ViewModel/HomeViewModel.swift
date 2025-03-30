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
    
    @Published var popularMovies:[Movie] = []
    @Published var trendingMovies:[Movie] = []
    
    init(){
        listPopularMoviesUseCase = UseCaseProvider.shared.getListPopularMoviesUseCase()
        listTrendingMoviesUseCase = UseCaseProvider.shared.getListTrendingMoviesUseCase()
    }
    func fetchPopularMovies() async {
        do {
            popularMovies = try await listPopularMoviesUseCase.execute().results.map{ item in
                item.toMovie()
            }
        } catch let error {
            print(error)
        }
    }
    func fetchTrendingMovies() async{
        do {
            trendingMovies =  try await listTrendingMoviesUseCase.execute().results.map { item in
                item.toMovie()
            }
        } catch let error {
            print(error)
        }
    }
    
}
