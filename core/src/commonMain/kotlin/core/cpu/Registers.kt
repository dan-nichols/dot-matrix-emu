@file:Suppress("PropertyName")
package core.cpu

class Registers {

    var stackPointer: Int = 0x0000
    var programCounter: Int = 0x0000

    var accumulator: Int = 0x00
    var flags = FlagsRegister()

    var B: Int = 0x00
    var C: Int = 0x00
    var D: Int = 0x00
    var E: Int = 0x00
    var H: Int = 0x00
    var L: Int = 0x00

    var AF get() = accumulator.concatByte(flags.value)
        set(value) {
            accumulator = value.readHighByte()
            flags.value = value.readLowByte()
        }

    var BC get() = B.concatByte(C)
        set(value) {
            B = value.readHighByte()
            C = value.readLowByte()
        }

    var DE get() = D.concatByte(E)
        set(value) {
            D = value.readHighByte()
            E = value.readLowByte()
        }

    var HL get() = H.concatByte(L)
        set(value) {
            H = value.readHighByte()
            L = value.readLowByte()
        }

    class FlagsRegister {
        var value: Int = 0x00

        val zero get() = value.readBit(7)
        val subtraction get() = value.readBit(6)
        val halfCarry get() = value.readBit(5)
        val carry get() = value.readBit(4)
    }
}

inline fun Int.readBit(bit: Int): Boolean = ((this shr (bit - 1)) and 0b1) == 0b1

inline fun Int.readHighByte(): Int = (this shr 8) and 0xFF

inline fun Int.readLowByte(): Int = this and 0xFF

inline fun Int.concatByte(byte: Int) = (this shl 8) or byte
