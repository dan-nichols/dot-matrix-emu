package io.github.kotlin.fibonacci.core.io

import io.github.kotlin.fibonacci.core.bus.Address
import io.github.kotlin.fibonacci.core.bus.AddressRange

class Io {

    class Inputs : Address(0xFF00) {

    }

    class Serial : AddressRange(0xFF01, 0xFF02) {

    }

    class Timer : AddressRange(0xFF04, 0xFF07) {

    }

    class InterruptFlags : Address(0xFF0F) {

    }

    /**
     * IE register is the last possible address and technically outside of the I/O block
     */
    class InterruptEnable : Address(0xFFFF) {

    }

    class Audio : AddressRange(0xFF10, 0xFF26) {

        class WavePattern : AddressRange(0xFF30, 0xFF3F) {

        }
    }

    class Lcd : AddressRange(0xFF40, 0xFF4B) {

    }

    class CgbAddresses : AddressRange(0xFF4F, 0xFF7F) {

    }
}
