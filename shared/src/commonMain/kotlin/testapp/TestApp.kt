package testapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.jibru.compose.UpnpInput
import kotlinx.datetime.Clock

object TestApp {

    @Composable
    operator fun invoke() {
        Screen()
    }

    @Composable
    fun Screen() {
        Column(modifier = Modifier.fillMaxSize()) {
            Text("CurrentTime:${Clock.System.now()}")
            Divider()
            UpnpInput(
                onValueChanged = {},
                modifier = Modifier.fillMaxWidth()
            )
            Divider()
            Button(
                onClick = { throw IllegalStateException("Test crash!") },
                modifier = Modifier.align(Alignment.End)
            ) { Text("AppCrash") }
        }
    }
}
