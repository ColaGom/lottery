plugins {
    id("com.android.application")
    kotlin("android")
}

dependencies {
    implementation(project(":shared"))

    with(libs) {
        implementation(bundles.app.ui)

        implementation(koin.android)
        implementation(androidx.core)
        implementation(androidx.lifecycle.runtime)
        implementation(androidx.lifecycle.viewmodel)
    }
}

android {
    compileSdk = libs.versions.compileSdk.get().toInt()
    defaultConfig {
        applicationId = "com.colagom.lottery.android"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}