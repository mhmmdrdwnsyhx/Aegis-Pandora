enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        id("com.android.library")
        id("com.android.application")
        id("org.jetbrains.kotlin.multiplatform")
        id("org.jetbrains.kotlin.plugin.serialization")
        id("org.jetbrains.kotlin.android")
        id("org.jetbrains.kotlin.plugin.compose")
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AegisPandora"
include(":AegisPandora_App")
include(":core")