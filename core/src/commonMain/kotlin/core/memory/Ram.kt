package io.github.kotlin.fibonacci.core.memory

import io.github.kotlin.fibonacci.core.bus.AddressRange

class Ram : AddressRange(0xC000, 0xDFFF) {



    /**
     * Echo RAM is marked as prohibited by Nintendo so we're going to just throw errors when
     * accessing these addresses for now. It's technically a mirror of work RAM but we're not
     * going to implement that.
     */
    class EchoRam : AddressRange(0xE000, 0xFDFF)
}
