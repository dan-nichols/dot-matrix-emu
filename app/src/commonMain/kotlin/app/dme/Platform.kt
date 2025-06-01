package app.dme

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform