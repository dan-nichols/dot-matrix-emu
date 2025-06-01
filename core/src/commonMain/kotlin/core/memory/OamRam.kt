package core.memory

import core.bus.AddressRange

class OamRam : AddressRange(0xFE00, 0xFE9F) {
    override val deviceName = "Object Attribute Mapper RAM (OAM)"
}
