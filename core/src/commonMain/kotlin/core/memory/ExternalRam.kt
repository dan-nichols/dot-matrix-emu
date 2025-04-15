package io.github.kotlin.fibonacci.core.memory

import io.github.kotlin.fibonacci.core.bus.AddressRange

class ExternalRam : AddressRange(0xA000, 0xBFFF) {
}