@file:OptIn(ExperimentalComposeUiApi::class)

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import testapp.TestApp

@Composable
internal fun App() {
    MaterialTheme(colors = darkColors()) {
        TestApp()
    }
}

expect fun getPlatformName(): String
