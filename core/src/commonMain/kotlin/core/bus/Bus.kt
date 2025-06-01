package core.bus

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map

fun interface BusRead {
    fun read(address: Int): Int
}

fun interface BusWrite {
    fun write(address: Int, byte: Int)
}

@OptIn(ExperimentalStdlibApi::class)
class Bus(
    vararg devices: Addressable
) : BusRead, BusWrite {
    private val mutableState = MutableStateFlow(devices.toList())

    val deviceState = mutableState.asStateFlow()

    fun getFlowOfBytesFromDevice(deviceName: String): Flow<Array<Int>> =
        deviceState.map { devices ->
            devices.first { it.deviceName == deviceName }.memory
        }

    override fun read(address: Int): Int {
        val currentState = mutableState.value

        return try {
            val device = currentState.first { it.range.contains(address) }
            device.read(address)
        } catch (_: NoSuchElementException) {
            throw IndexOutOfBoundsException("Address ${address.toHexString()} has no registered device on the Bus")
        }
    }

    override fun write(address: Int, byte: Int) {
        val currentState = mutableState.value.toMutableList()

        val deviceIndex = currentState
            .indexOfFirst { it.range.contains(address) }

        if (deviceIndex < 0) {
            throw IndexOutOfBoundsException("Address ${address.toHexString()} has no registered device on the Bus")
        }

        val device = currentState[deviceIndex]

        device.write(address, byte)

        currentState[deviceIndex] = device
        mutableState.value = currentState
    }
}
