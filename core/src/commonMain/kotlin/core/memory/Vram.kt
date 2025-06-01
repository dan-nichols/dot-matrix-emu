package core.memory

import core.bus.AddressRange

class Vram : AddressRange(0x8000, 0x9FFF) {
    override val deviceName = "Video RAM (VRAM)"
}
