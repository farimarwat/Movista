import SwiftUI
import shared

struct ContentView: View {
    @StateObject var viewModel:HomeViewModel = HomeViewModel()
	var body: some View {
        NavigationStack{
            VStack{
                TabView {
                    ForEach(viewModel.popularMovies,id:\.id){movie in
                        PopularMovieItem(movie: movie)
                    }
                }
                .tabViewStyle(.page)
                .frame(height: 350)
                Spacer()
            }
            .onAppear{
                Task{
                    await viewModel.fetchPopularMovies()
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
