//
//  SeriesItem.swift
//  iosApp
//
//  Created by mac on 30/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

struct SeriesItem: View {
    var series:Series
    var body: some View {
        ZStack(alignment:.bottom){
            AsyncImage(url: URL(string:series.getFullPosterPath(imageWidth: 500))){image in
                image.image?
                    .resizable()
                    .scaledToFill()
                    .clipped()
                
            }
            Text(series.name)
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
    let breakingBadSeries = Series(
        adult: false,
        backdropPath: "/9faGSFi5jam6pDWGNd0p8JcJgXQ.jpg",
        firstAirDate: "2008-01-20",
        genreIds: [18, 80],
        id: 1396,
        name: "Breaking Bad",
        originCountry: ["US"],
        originalLanguage: "en",
        originalName: "Breaking Bad",
        overview: "Walter White, a New Mexico chemistry teacher, is diagnosed with Stage III cancer and given a prognosis of only two years left to live. He becomes filled with a sense of fearlessness and an unrelenting desire to secure his family's financial future at any cost as he enters the dangerous world of drugs and crime.",
        popularity: 108.2664,
        posterPath: "/ineLOBPG8AZsluYwnkMpHRyu7L.jpg",
        voteAverage: 8.9,
        voteCount: 15284
    )
    SeriesItem(series: breakingBadSeries)
}
