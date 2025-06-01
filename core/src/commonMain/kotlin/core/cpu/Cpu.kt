package core.cpu

import core.bus.BusRead
import core.bus.BusWrite
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.microseconds

class Cpu(
    private val busRead: BusRead,
    private val busWrite: BusWrite,
) {

    private var clockCycles = 0

    private val registers = Registers()

    suspend fun run() {
        while (true) {
            fetch()
            decode()
            execute()
        }
    }

    private suspend fun fetch() {
        delay(10.microseconds)
    }

    private suspend fun decode() {

    }

    private suspend fun execute() {
        busWrite.write(9, 0)
//        emit(clockCycles++)
    }
}
