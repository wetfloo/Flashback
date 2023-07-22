@file:Suppress("UnstableApiUsage")

private val applicationPackage = "io.wetfloo.flashback"

plugins {
    id("buildlogic.android.application")
    id("buildlogic.android.hilt")
    id("buildlogic.android.room")
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.android.safeargs)
}

android {
    defaultConfig {
        applicationId = applicationPackage
        versionCode = 1
        versionName = "0.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        @Suppress("UNUSED_VARIABLE")
        val release by getting {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile(name = "proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    namespace = applicationPackage
}

dependencies {
    implementation(libs.androidx.core)
    implementation(libs.androidx.activity)
    implementation(libs.datastore.preferences)
    implementation(libs.bundles.lifecycle)
    implementation(libs.bundles.lifecycleCompose)
    implementation(libs.bundles.navigation)

    implementation(libs.kotlinx.coroutines)
    implementation(libs.kotlinx.coroutines.android)

    implementation(libs.compose.material3)
    implementation(libs.compose.icons)
    implementation(libs.compose.activity)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.navigation)
    debugImplementation(libs.compose.ui.tooling)
    implementation(libs.accompanist.systemuicontroller)
    implementation(libs.composeShimmer)
    implementation(libs.compose.navigation.hilt)

    implementation(libs.composeDestinations)
    ksp(libs.composeDestinations.compiler)

    implementation(libs.result)
    implementation(libs.resultCoroutines)

    implementation(libs.coil)
    implementation(libs.coil.compose)
    implementation(libs.coil.gif)

    implementation(libs.retrofit)
    implementation(libs.retrofit.moshi)
    implementation(libs.okhttp3)
    implementation(libs.okhttp3.logging)
    implementation(libs.moshi)
    implementation(libs.moshi.adapters)
    ksp(libs.moshi.codegen)

    // Detect memory leaks
    //    debugImplementation(libs.square.leakcanary)
}
