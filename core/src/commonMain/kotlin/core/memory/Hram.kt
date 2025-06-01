package core.memory

import core.bus.AddressRange

class Hram : AddressRange(0xFF80, 0xFFFE) {
    override val deviceName = "High RAM (HRAM)"
}
