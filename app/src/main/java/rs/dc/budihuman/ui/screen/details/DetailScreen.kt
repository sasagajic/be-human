package rs.dc.budihuman.ui.screen.details

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailScreen(name: String?) {
    Box() {
        Text(text = "Hello $name")
    }
}