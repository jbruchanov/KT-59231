import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

actual fun getPlatformName(): String = "iOS"

fun MainViewController(): UIViewController {
    return ComposeUIViewController {
        App()
    }
}
