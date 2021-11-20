plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

dependencies {
    implementation(project(":shared"))

    with(libs) {
        implementation(bundles.android.x)
        implementation(bundles.android.compose)
        implementation(bundles.android.ui)

        implementation(koin.android)
        implementation(koin.androidxCompose)
        implementation(androidx.core)
        implementation(androidx.lifecycle.runtime)
        implementation(androidx.lifecycle.viewmodel)
        implementation(androidx.navigationCompose)
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
    buildFeatures {
        compose = true
        buildConfig = false
        aidl = false
        renderScript = false
        resValues = false
        shaders = false
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }
}