import SwiftUI
import shared

@main
struct iOSApp: App {
    init(){
        AppModuleKt.doInitKoin()
    }
	var body: some Scene {
        var viewModel:HomeViewModel = HomeViewModel()
		WindowGroup {
			ContentView()
                .environmentObject(viewModel)
		}
	}
}
