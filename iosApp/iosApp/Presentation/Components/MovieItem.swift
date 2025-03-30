//
//  MovieItem.swift
//  iosApp
//
//  Created by mac on 30/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MovieItem: View {
    var movie:Movie
    var body: some View {
        ZStack(alignment:.bottom){
            AsyncImage(url: URL(string:movie.getFullPosterPath(imageWidth: 500))){image in
                image.image?
                    .resizable()
                    .scaledToFill()
                    .clipped()
                
            }
            Text(movie.title)
                .font(.caption)
                .frame(maxWidth: .infinity)
                .padding(.horizontal,2)
                .background(Color("ColorPrimary"))
                .foregroundColor(Color("ColorOnPrimary"))
                .lineLimit(1)
                .padding(.bottom,12)
            
        }
        .frame(width: 150, height: 200)
        .cornerRadius(8)
        .shadow(radius: 8)
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
    MovieItem(movie: dummyMovie)
}
