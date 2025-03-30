import SwiftUI
import shared

struct ContentView: View {
    @StateObject var viewModel:HomeViewModel = HomeViewModel()
	var body: some View {
        NavigationStack{
            VStack{
                //Popular Movies
                TabView {
                    ForEach(viewModel.popularMovies,id:\.id){movie in
                        PopularMovieItem(movie: movie)
                    }
                }
                .tabViewStyle(.page)
                .frame(height: 350)
                
                //Trending Movies
                ScrollView(.horizontal) {
                    HStack{
                        ForEach(viewModel.trendingMovies,id:\.id){movie in
                            MovieItem(movie: movie)
                        }
                    }
                }
                
                Spacer()
            }
            .onAppear{
                Task{
                    await viewModel.fetchPopularMovies()
                    await viewModel.fetchTrendingMovies()
                }
            }
            .toolbar {
                ToolbarItem(placement: .topBarLeading) {
                    Text("Movista")
                        .font(.title2)
                }
                ToolbarItem(placement: .topBarTrailing) {
                    Button(action: {
                        // Search action
                        print("Search tapped")
                    }) {
                        Image(systemName: "magnifyingglass")
                            .foregroundColor(.blue)
                    }
                }
            }
        }
        
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
