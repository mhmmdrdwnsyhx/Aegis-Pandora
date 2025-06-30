plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.mhmmdrdwnsyhx.aegispandora.android"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.mhmmdrdwnsyhx.aegispandora.android"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.12"
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
    implementation(libs.jbcrypt)
    implementation(libs.androidx.runtime)
    implementation(libs.androidx.ui.v183)
    implementation(libs.androidx.foundation.v160)
    implementation(libs.androidx.material3.v120)
    implementation(libs.androidx.ui.tooling.preview.v160)
    implementation(libs.androidx.activity.compose)
}