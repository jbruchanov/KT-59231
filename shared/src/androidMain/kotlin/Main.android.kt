import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

actual fun getPlatformName(): String = "Android"

@Composable
fun MainView() {
    val activity = LocalContext.current as ComponentActivity
    App()
}
