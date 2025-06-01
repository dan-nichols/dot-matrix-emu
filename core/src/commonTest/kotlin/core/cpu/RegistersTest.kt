package core.cpu

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RegistersTest {

    @Test
    fun `The program counter register is a simple 16bit register that can be set and read`() {
        val registers = Registers()

        assertEquals(0x0000, registers.programCounter)
        registers.programCounter = 0xB7C8
        assertEquals(0xB7C8, registers.programCounter)
    }

    @Test
    fun `The stack pointer register is a simple 16bit register that can be set and read`() {
        val registers = Registers()

        assertEquals(0x0000, registers.stackPointer)
        registers.stackPointer = 0xB7C8
        assertEquals(0xB7C8, registers.stackPointer)
    }

    @Test
    fun `The AF register is a combination of the accumulator and flag registers`() {
        val registers = Registers()
        registers.accumulator = 0xB7
        registers.flags.value = 0xC8

        assertEquals(0xB7C8, registers.AF)
    }

    @Test
    fun `The accumulator and flag registers can be derived from the AF register`() {
        val registers = Registers()
        registers.AF = 0xE8B1

        assertEquals(0xE8, registers.accumulator)
        assertEquals(0xB1, registers.flags.value)
    }

    @Test
    fun `The BC register is a combination of the B and C registers`() {
        val registers = Registers()
        registers.B = 0xB7
        registers.C = 0xC8

        assertEquals(0xB7C8, registers.BC)
    }

    @Test
    fun `The B and C registers can be derived from the BC register`() {
        val registers = Registers()
        registers.BC = 0xE8B1

        assertEquals(0xE8, registers.B)
        assertEquals(0xB1, registers.C)
    }

    @Test
    fun `The DE register is a combination of the D and E registers`() {
        val registers = Registers()
        registers.D = 0xB7
        registers.E = 0xC8

        assertEquals(0xB7C8, registers.DE)
    }

    @Test
    fun `The D and E registers can be derived from the DE register`() {
        val registers = Registers()
        registers.DE = 0xE8B1

        assertEquals(0xE8, registers.D)
        assertEquals(0xB1, registers.E)
    }

    @Test
    fun `The HL register is a combination of the H and L registers`() {
        val registers = Registers()
        registers.H = 0xB7
        registers.L = 0xC8

        assertEquals(0xB7C8, registers.HL)
    }

    @Test
    fun `The H and L registers can be derived from the HL register`() {
        val registers = Registers()
        registers.HL = 0xE8B1

        assertEquals(0xE8, registers.H)
        assertEquals(0xB1, registers.L)
    }

    @Test
    fun `The Zero flag is in the 7th bit of the flags register`() {
        val registers = Registers()
        val flags = registers.flags

        flags.value = 0b01000000
        assertTrue(flags.zero)

        flags.value = 0b10111111
        assertFalse(flags.zero)
    }

    @Test
    fun `The Subtraction flag is in the 6th bit of the flags register`() {
        val registers = Registers()
        val flags = registers.flags

        flags.value = 0b00100000
        assertTrue(flags.subtraction)

        flags.value = 0b11011111
        assertFalse(flags.subtraction)
    }

    @Test
    fun `The Half Carry flag is in the 5th bit of the flags register`() {
        val registers = Registers()
        val flags = registers.flags

        flags.value = 0b00010000
        assertTrue(flags.halfCarry)

        flags.value = 0b11101111
        assertFalse(flags.halfCarry)
    }

    @Test
    fun `The Carry flag is in the 4th bit of the flags register`() {
        val registers = Registers()
        val flags = registers.flags

        flags.value = 0b00001000
        assertTrue(flags.carry)

        flags.value = 0b11110111
        assertFalse(flags.carry)
    }
}