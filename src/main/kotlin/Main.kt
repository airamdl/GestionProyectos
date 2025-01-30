import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import screens.LoginScreen


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Login",
        state = rememberWindowState(width = 500.dp, height = 600.dp)
    ) {
        LoginScreen()
    }
}