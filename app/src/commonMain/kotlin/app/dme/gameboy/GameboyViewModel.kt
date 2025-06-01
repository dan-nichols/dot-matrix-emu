package app.dme.gameboy

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.Gameboy
import dotmatrixemu.app.generated.resources.Res
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi

class GameboyViewModel(
    private val gameboy: Gameboy
) : ViewModel() {

    private val mutableState = MutableStateFlow(Pixels())
    val state = mutableState.asStateFlow()

    init {
        viewModelScope.launch {
            gameboy.lcdState.collect { lcdBytes ->
                mutableState.value = Pixels(
                    xy = lcdBytes.map { byte ->
                        when (byte) {
                            0 -> Color.Red
                            1 -> Color.Cyan
                            2 -> Color.Gray
                            else -> Color.LightGray
                        }
                    },
                    backgroundColor = Color.Gray,
                )
            }
        }

        @OptIn(ExperimentalResourceApi::class)
        viewModelScope.launch {
            gameboy.boot(
                bootRomBytes = Res.readBytes("files/dmg_boot.bin")
                    .map { it.toInt() }
                    .toTypedArray()
            )
        }
    }

    data class Pixels(
        /**
         * Should always be 160x144 pixels.
         *
         * Each pixel only uses 2 bits
         */
        val xy: List<Color> = emptyList(),

        val backgroundColor: Color = Color.Gray,
    )

    data class VramState(
        val tiles: List<Tile>,
        val tileMap0: List<List<Int>>,
        val tileMap1: List<List<Int>>,
    ) {
        data class Tile(
            val bytes: List<Int>,

            val pixels: List<Color>,
        )
    }
}
