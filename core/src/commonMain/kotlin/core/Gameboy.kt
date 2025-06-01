package core

import core.bus.Bus
import core.cpu.Cpu
import core.io.Io
import core.memory.Vram
import core.rom.Rom
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Gameboy {

    var bus = initialiseBus(
        bootRomBytes = arrayOf(),
    )

    suspend fun boot(bootRomBytes: Array<Int>) {
        bus = initialiseBus(
            bootRomBytes = bootRomBytes,
        )

        Cpu(bus::read, bus::write).run()
    }

    val lcdState = bus.getFlowOfBytesFromDevice("Liquid Crystal Display (LCD)")

    val vramState = bus.getFlowOfBytesFromDevice("Video RAM (VRAM)")

    private fun initialiseBus(bootRomBytes: Array<Int>, cartridgeRomBytes: Array<Int> = arrayOf()) =
        Bus(
            Rom.BootRom(bootRomBytes),
            Io.Lcd(),
            Vram(),
        )
}
