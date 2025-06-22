package com.mhmmdrdwnsyhx.aegispandora.core.device

object SecureFolder {
    private val files = mutableMapOf<String, String>()
    fun storeFile(filename: String, content: String) {
        println("Storing file in secure folder: $filename")
        files[filename] = content
    }

    fun clearFolder() {
        files.clear()
    }
    fun simulateListFiles() = files.keys.toList()
}