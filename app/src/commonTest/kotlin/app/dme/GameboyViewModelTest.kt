package app.dme

import app.cash.turbine.test
import app.dme.gameboy.GameboyViewModel
import core.io.Io
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GameboyViewModelTest {

    @Test
    fun testGB() = runTest {
        val vm = GameboyViewModel()
        vm.state.test {
            awaitItem() // Initial value
            val item: Io.Lcd.Pixels = awaitItem()
            assertEquals(0x31, item.bytes.first())
        }
    }
}