package core.rom

import core.bus.AddressRange

class Rom {

    class BootRom(bytes: Array<Int>) : AddressRange(0x0000, 0x00FF) {

        override val deviceName = "Boot ROM"

        init {
            memory = bytes
        }
    }

    class FixedRom : AddressRange(0x0000, 0x3FFF) {
        override val deviceName = "Fixed Cartridge ROM"
    }

    class SwitchableRom : AddressRange(0x4000, 0x7FFF) {
        override val deviceName = "Switchable Cartridge ROM"
    }
}