package core.bus

class UnusableAddress : AddressRange(0xFEA0, 0xFEFF) {
    override val deviceName = "Unusable addresses"
}
