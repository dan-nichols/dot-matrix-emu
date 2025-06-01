package core.memory

import core.bus.AddressRange

class ExternalRam : AddressRange(0xA000, 0xBFFF) {
    override val deviceName = "External RAM"
}