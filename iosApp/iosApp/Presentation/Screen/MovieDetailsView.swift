//
//  MovieDetailsView.swift
//  iosApp
//
//  Created by mac on 02/04/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct MovieDetailsView: View {
    var movieId: String
    @StateObject var viewModel = MovieDetailsViewModel()
    
    var body: some View {
        ZStack {
            if let movie = viewModel.movie {
                ScrollView(.vertical) {
                    VStack(alignment: .leading, spacing: 8) {
                        AsyncImage(url: URL(string: movie.getFullPosterPath(imageWidth: 500))) { phase in
                            if let image = phase.image {
                                image
                                    .resizable()
                                    .aspectRatio(contentMode: .fill)
                                    .frame(maxWidth: .infinity)
                                    .frame(height: 300)
                                    .clipped()
                            } else if phase.error != nil {
                                Color.gray
                                    .frame(height: 300)
                                    .overlay(Image(systemName: "photo"))
                            } else {
                                ProgressView()
                                    .frame(height: 300)
                            }
                        }
                        
                        Text(movie.title)
                            .font(.title)
                            .fontWeight(.bold)
                            .multilineTextAlignment(.center)
                            .padding(.horizontal)
                        
                        Text(movie.overview)
                            .font(.body)
                            .lineSpacing(6)
                            .padding(.horizontal)
                        LazyVGrid(columns: [GridItem(),GridItem(),GridItem(),GridItem()], content: {
                            ForEach(movie.genres, id:\.id){g in
                                Chip(label:g.name)
                            }
                        })
                        .padding(8)
                    }
                    .background(Color(.systemBackground))
                    .shadow(color: .black.opacity(0.2), radius: 16, x: 0, y: 6)
                    .padding(.bottom,8)
                   
                
                }
            }
        }
        .onAppear {
            Task {
                await viewModel.fetchMovieDetails(id: movieId)
            }
        }
        Spacer()
    }
}

#Preview {
    MovieDetailsView(movieId: "\(200)")
}
