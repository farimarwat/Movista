//
//  MovieDetailsViewModel.swift
//  iosApp
//
//  Created by mac on 02/04/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import shared

class MovieDetailsViewModel:ObservableObject{
    
    @Published var movie:MovieDetailsDto? = nil
    
    var getMovieDetailsUseCase:GetMovieDetailsUseCase
    
    init() {
        print("Movie Details View Model created")
        getMovieDetailsUseCase = UseCaseProvider.shared.getGetMoviesDetailsUseCase()
    }
    
    func fetchMovieDetails(id:String) async{
        do {
            print("Calling \(id)")
            movie = try await getMovieDetailsUseCase.execute(id: id)
            print(movie?.title)
        } catch let error {
            print(error)
        }
    }
}
