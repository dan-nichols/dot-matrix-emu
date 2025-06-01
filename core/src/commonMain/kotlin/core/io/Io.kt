package core.io

import core.bus.Address
import core.bus.AddressRange

class Io {

    class Inputs : Address(0xFF00) {
        override val deviceName = "Inputs"
    }

    class Serial : AddressRange(0xFF01, 0xFF02) {
        override val deviceName = "Serial"
    }

    class Timer : AddressRange(0xFF04, 0xFF07) {
        override val deviceName = "Timer"
    }

    class InterruptFlags : Address(0xFF0F) {
        override val deviceName = "Interrupt Flags"
    }

    /**
     * IE register is the last possible address and technically outside of the I/O block
     */
    class InterruptEnable : Address(0xFFFF) {
        override val deviceName = "Interrupt Enable Register"
    }

    class Audio : AddressRange(0xFF10, 0xFF26) {
        override val deviceName = "Audio"

        class WavePattern : AddressRange(0xFF30, 0xFF3F) {
            override val deviceName = "Wave Pattern"
        }
    }

    class Lcd : AddressRange(0xFF40, 0xFF4B) {
        override val deviceName = "Liquid Crystal Display (LCD)"

        class Pixels(val bytes: Array<Int>) {
            // 160 x 144 px

        }
    }

    class CgbAddresses : AddressRange(0xFF4F, 0xFF7F) {
        override val deviceName = "Color Gameboy Addresses"
    }
}
