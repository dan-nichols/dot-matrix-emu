package app.rollvault.dme

import io.github.kotlin.fibonacci.generateFibi

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name} ${generateFibi()}!"
    }
}
