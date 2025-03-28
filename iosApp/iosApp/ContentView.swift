import SwiftUI
import shared

struct ContentView: View {

	var body: some View {
		Text("")
            .onAppear{
                Task{
                    do{
                        let movieDto = try await ProvideUseCases.shared.getListPopularMoviesUseCase().invoke()
                        movieDto.results.forEach { item in
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
