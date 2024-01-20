package com.walcker.nasa_voyager

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform