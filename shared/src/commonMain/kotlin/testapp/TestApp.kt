package testapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

object TestApp {

    @Composable
    operator fun invoke() {
        Screen()
    }

    @Composable
    fun Screen() {
        Column(modifier = Modifier.fillMaxSize()) {
            Text("CurrentTime")
            Divider()
            Divider()
            Button(
                onClick = { throw IllegalStateException("Test crash!") },
                modifier = Modifier.align(Alignment.End)
            ) { Text("AppCrash") }
        }
    }
}
