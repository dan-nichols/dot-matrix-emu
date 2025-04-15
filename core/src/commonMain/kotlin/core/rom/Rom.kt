package io.github.kotlin.fibonacci.core.rom

import io.github.kotlin.fibonacci.core.bus.AddressRange

class Rom {

    class BootRom : AddressRange(0x0000, 0x00FF) {

    }

    class FixedRom : AddressRange(0x0000, 0x3FFF) {

    }

    class SwitchableRom : AddressRange(0x4000, 0x7FFF) {

    }
}