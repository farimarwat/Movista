import SwiftUI
import shared

struct ContentView: View {
    
    let listPopularMovieUseCase:ListPopularMoviesUseCase
    init(){
        listPopularMovieUseCase = ProvideUseCase.shared.getListPopularMoviesUseCase()
    }
	var body: some View {
		Text("")
            .onAppear{
                Task{
                    do{
                        
                        let movieDTO = try await listPopularMovieUseCase.execute()
                        movieDTO.results.forEach { item in
                            print(item.title)
                        }
                    }catch let error {
                        print(error)
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
