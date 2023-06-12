import SwiftUI

import MacroAlarmShared
import FirebaseCore
import FirebaseAnalytics

@main
struct iOSApp: App {

	@UIApplicationDelegateAdaptor(AppDelegate.self) var appDelegate

	init() {
        //print("Kotlin:\(IosSystemClock.self.shared.localDateTime())")
	}

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}

class AppDelegate: NSObject, UIApplicationDelegate {
	func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        FirebaseApp.configure()
        Analytics.logEvent("AppStart", parameters: ["platform": "iOS"])
		return true
	}
}
