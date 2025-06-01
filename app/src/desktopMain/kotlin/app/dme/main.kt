package app.dme

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import app.dme.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "DotMatrixEmu",
    ) {
        App()
    }
}