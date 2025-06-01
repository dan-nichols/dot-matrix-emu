package app.dme.gameboy

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private const val resolutionX = 159
private const val resolutionY = 143

private val pixelDip = 2.dp

private val dipX = pixelDip * resolutionX
private val dipY = pixelDip * resolutionY

@Composable
fun LcdDisplay(pixelsXy: List<Color>, backgroundColor: Color) {
    Canvas(modifier = Modifier.size(dipX, dipY)) {
        val sizeX = size.width / resolutionX
        val sizeY = size.height / resolutionY

        drawRect(backgroundColor)

        pixelsXy.mapIndexed { index, pixelColor ->
            val row: Int = if (index < resolutionX) 0 else (index / resolutionX)
            val column = index.mod(resolutionX)

            drawRect(
                color = pixelColor,
                topLeft = Offset(sizeX * column, sizeY * row),
                size = Size(sizeX, sizeY),
            )
        }
    }
}
