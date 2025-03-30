import SwiftUI
import shared

struct ContentView: View {
    @StateObject var viewModel:HomeViewModel = HomeViewModel()
	var body: some View {
        NavigationStack{
            ScrollView(.vertical){
                VStack(alignment:.leading, spacing: 4){
                    //Popular Movies
                    TabView {
                        ForEach(viewModel.popularMovies,id:\.id){movie in
                            PopularMovieItem(movie: movie)
                        }
                    }
                    .tabViewStyle(.page)
                    .frame(height: 350)
                    
                    //Trending Movies
                    if !viewModel.trendingMovies.isEmpty {
                        Text("Trending Movies")
                            .font(.title3)
                        ScrollView(.horizontal) {
                            HStack{
                                ForEach(viewModel.trendingMovies,id:\.id){movie in
                                    MovieItem(movie: movie)
                                }
                            }
                        }
                    }
                    
                    //Top Rated Series
                    if !viewModel.topRatedSeries.isEmpty{
                        Text("Top Rated Series")
                            .font(.title3)
                        ScrollView(.horizontal){
                            HStack{
                                ForEach(viewModel.topRatedSeries,id:\.id){item in
                                    SeriesItem(series: item)
                                }
                            }
                        }
                    }
                    
                
                }
            }
            .onAppear{
                Task{
                    await viewModel.fetchPopularMovies()
                    await viewModel.fetchTrendingMovies()
                    await viewModel.fetchTopRatedSeries()
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
