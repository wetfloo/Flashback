group = "buildlogic"

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

kotlin {
    jvmToolchain(17)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "buildlogic.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidFeature") {
            id = "buildlogic.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }

        register("androidComposeLibrary") {
            id = "buildlogic.android.compose-library"
            implementationClass = "AndroidComposeLibraryConventionPlugin"
        }

        register("androidLibrary") {
            id = "buildlogic.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidHilt") {
            id = "buildlogic.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

        register("androidRoom") {
            id = "buildlogic.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
    }
}
