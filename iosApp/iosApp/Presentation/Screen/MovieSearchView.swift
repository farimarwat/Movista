//
//  MovieSearchView.swift
//  iosApp
//
//  Created by mac on 30/03/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct MovieSearchView: View {
    @EnvironmentObject var viewModel:HomeViewModel
    @State var query:String = ""
    var body: some View {
        TextField("Search movies...", text: $query)
            .padding(.horizontal, 16)
            .padding(.vertical, 12)
            .background(
                RoundedRectangle(cornerRadius: 16)
                    .fill(Color(.systemBackground))
                    .shadow(color: .black.opacity(0.05), radius: 2, x: 0, y: 2)
                    .overlay(
                        RoundedRectangle(cornerRadius: 12)
                            .stroke(Color.blue.opacity(0.3), lineWidth: 1)
                    )
            )
            .padding(8)
            .submitLabel(.search)
            .onSubmit{
                Task{
                    await viewModel.fetchSearchMovies(query: query)
                }
            }
        Spacer()
        ScrollView(.vertical) {
            ForEach(viewModel.searchedMovies,id:\.id){item in
                MovieSearchItem(movie: item)
            }
        }
    }
}

#Preview {
    MovieSearchView()
}
