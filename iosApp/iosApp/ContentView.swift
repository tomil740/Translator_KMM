import SwiftUI
import shared

struct ContentView: View {
    private let appModule = AppModule()
	//let greet = Greeting().greeting()

    var body: some View {
       
        ZStack {
        Color.background
                .ignoresSafeArea()
            
            TranslateScreen(
                historyDataSource: appModule.historyDataSource,
                translateUseCase: appModule.translateUseCase
            )
        }
            
        }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
