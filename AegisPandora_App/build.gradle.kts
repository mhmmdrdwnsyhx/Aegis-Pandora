plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0"
}

android {
    namespace = "com.mhmmdrdwnsyhx.aegispandora.android"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.mhmmdrdwnsyhx.aegispandora.android"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":core"))
    implementation(libs.androidx.runtime)
    implementation(libs.androidx.ui.v183)
    implementation(libs.androidx.foundation.v160)
    implementation(libs.androidx.material3.v120)
    implementation(libs.androidx.ui.tooling.preview.v160)
    implementation(libs.androidx.activity.compose)
}
