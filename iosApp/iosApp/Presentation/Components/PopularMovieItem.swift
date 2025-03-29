//
//  PopularMoviesView.swift
//  iosApp
//
//  Created by mac on 29/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct PopularMovieItem: View {
    var movie:Movie
    var body: some View {
        VStack(spacing:0){
            AsyncImage(url: URL(string: movie.getFullbackDropPath(imageWidth: 500))){image in
                image
                    .image?.resizable()
                    .scaledToFill()
                    .frame(height: 250)
            }
            VStack(alignment:.leading){
                Text(movie.title)
                    .font(.title3)
                HStack{
                    Image(systemName: "star.fill")
                        .foregroundColor(Color.yellow)
                    Text(String(format: "%.2f", movie.voteAverage))
                }
            }
            .frame(maxWidth: .infinity, alignment: .leading)
            .padding(.horizontal,8)
            .padding(.vertical,8)
            .background(Color("ColorPrimaryContainer"))
            .shadow(radius: 8)
            
        }
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

    PopularMovieItem(movie: dummyMovie)
}
