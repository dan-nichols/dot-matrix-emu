package core.rom

import kotlin.test.Test
import kotlin.test.assertEquals

class BootRomTest {
    @Test
    fun `The Boot ROM should have exactly 256 addressable entries in memory`() {
        val bootRom = Rom.BootRom()

        assertEquals(256, bootRom.memory.size)
    }
}
