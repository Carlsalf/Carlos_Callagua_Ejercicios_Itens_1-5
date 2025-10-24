plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "es.ua.eps.filmoteca"
    compileSdk = 35

    defaultConfig {
        applicationId = "es.ua.eps.filmoteca"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    // Java/Kotlin 17 (requerido por AGP 8.x)
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    // Compose ON
    buildFeatures {
        compose = true
        viewBinding = true // por si usas XML en otras pantallas
    }
    composeOptions {
        // Con Kotlin 1.9.25 usa Compose Compiler 1.5.15
        kotlinCompilerExtensionVersion = "1.5.15"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // BOM de Compose (evita poner versiones en ui/material3/etc.)
    implementation(platform("androidx.compose:compose-bom:2024.08.00"))

    // Compose básico + Material3
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")

    // Necesario porque usas setContent{} en AboutActivity
    implementation("androidx.activity:activity-compose:1.9.3")

    // Soporte XML (por si usas activity_about.xml)
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Debug tooling
    debugImplementation("androidx.compose.ui:ui-tooling")
}
