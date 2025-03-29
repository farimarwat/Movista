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
    
    @Published var popularMovies:[Movie] = []

    init(){
        listPopularMoviesUseCase = ProvideUseCase.shared.getListPopularMoviesUseCase()
    }
    func fetchPopularMovies() async {
        do {
            popularMovies = try await listPopularMoviesUseCase.execute().results.map({ item in
                print(item.title)
                return item.toMovie()
            })
        } catch let error {
            print(error)
        }
    }
}
