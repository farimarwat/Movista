//
//  MovieSearchItem.swift
//  iosApp
//
//  Created by mac on 30/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MovieSearchItem: View {
    var movie: Movie
    
    var body: some View {
        HStack(spacing: 8) {
            // Movie poster image
            AsyncImage(url: URL(string: movie.getFullbackDropPath(imageWidth: 500))) { phase in
                if let image = phase.image {
                    image
                        .resizable()
                        .scaledToFill()
                        .frame(width: 150, height: 100)
                        .clipped()
                } else if phase.error != nil {
                    Color.gray // Error state
                } else {
                    ProgressView() // Loading state
                }
            }
            .frame(width: 150, height: 100)
            
            // Movie details
            VStack(alignment: .leading, spacing: 4) {
                // Title
                Text(movie.title)
                    .font(.headline)
                    .lineLimit(1)
                    .truncationMode(.tail)
                
                Spacer()
                
                // Rating row
                HStack(spacing: 4) {
                    Image(systemName: "star.fill")
                        .foregroundColor(.yellow)
                    Text(String(format: "%.1f", movie.voteAverage))
                        .font(.subheadline)
                }
                
                // Language
                Text("Language: \(movie.originalLanguage.uppercased())")
                    .font(.caption)
                
                // Release date
                Text("Released on: \(movie.releaseDate)")
                    .font(.caption)
                
                Spacer()
            }
            .frame(maxWidth: .infinity, alignment: .leading)
            .padding(.vertical, 4)
        }
        .frame(maxWidth: .infinity, minHeight: 100, maxHeight: 100)
        .padding(.vertical,8)
        .background(Color(.systemBackground))
        .cornerRadius(8)
        .shadow(radius: 4)
        .padding(.bottom, 2)
    }
}
#Preview {
    let dummyMovie = Movie(
        adult: false,
        backdropPath: "/m2mzlsJjE3UAqeUB5fLUkpWg4Iq.jpg",
        genreIds: [53, 878], // KotlinInt translates to Int32 in Swift
        id: 1165067,
        originalLanguage: "en",
        originalTitle: "Cosmic Chaos",
        overview: "Battles in virtual reality, survival in a post-apocalyptic wasteland, a Soviet spaceship giving a distress signal - Fantastic stories created with advanced special effects and passion.",
        popularity: 573.0464,
        posterPath: "/mClzWv7gBqgXfjZXp49Enyoex1v.jpg",
        releaseDate: "2023-08-03",
        title: "Cosmic Chaos",
        video: false,
        voteAverage: 5.2,
        voteCount: 10
    )
    MovieSearchItem(movie: dummyMovie)
}
