package core.bus

interface Addressable {
    val deviceName: String
    val range: IntRange
    var memory: Array<Int>

    fun write(address: Int, byte: Int) {
        validateAddress(address)
        val index = address - range.first
        memory[index] = byte
    }

    fun read(address: Int): Int {
        validateAddress(address)
        val index = address - range.first
        return memory[index]
    }

    @OptIn(ExperimentalStdlibApi::class)
    fun validateAddress(address: Int) {
        if (!range.contains(address)) {
            throw IndexOutOfBoundsException(
                "Attempting to read device $deviceName at address ${address.toHexString()}, " +
                        "but device only supports addresses from ${range.first.toHexString()} to ${range.last.toHexString()}"
            )
        }
    }
}

abstract class Address(private val address: Int) : Addressable {

    override val range get() = address..address

    override var memory = arrayOf(0)
}

abstract class AddressRange(private val start: Int, private val end: Int) : Addressable {

    override val range get() = start..end

    private val addressCount: Int
        get() = range.last - range.first + 1

    override var memory = Array(addressCount) { 0 }
}
