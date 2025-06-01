package app.dme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import app.dme.gameboy.LcdDisplay
import kotlin.random.Random

val xy: List<Color> =
    (1..160)
        .flatMap {
            (1..144).map {
                Random.nextInt(0, 3).let {
                    when (it) {
                        0 -> Color.Red
                        1 -> Color.Cyan
                        2 -> Color.Gray
                        else -> Color.LightGray
                    }
                }
            }
        }

@Composable
@Preview
fun LcdPreview() {
    MaterialTheme {
        LcdDisplay(
            pixelsXy = xy,
            backgroundColor = Color.Gray,
        )
    }
}
