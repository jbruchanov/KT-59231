import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

actual fun getPlatformName(): String = "Android"

@Composable
fun MainView() {
    val activity = LocalContext.current as ComponentActivity
    App()
}
