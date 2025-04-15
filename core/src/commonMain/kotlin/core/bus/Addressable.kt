package io.github.kotlin.fibonacci.core.bus

interface Addressable {
    val range: IntRange
}

abstract class Address(private val address: Int) : Addressable {

    override val range get() = address..address
}

abstract class AddressRange(private val start: Int, private val end: Int) : Addressable {

    override val range get() = start..end
}
