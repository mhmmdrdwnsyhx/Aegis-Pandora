package com.mhmmdrdwnsyhx.aegispandora

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform