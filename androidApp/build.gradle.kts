plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.ksp)
    id("de.jensklingenberg.ktorfit") version "1.10.1"
}

android {
    namespace = libs.versions.namespace.get()
    compileSdk = libs.versions.targetSdk.get().toInt()
    defaultConfig {
        applicationId = libs.versions.namespace.get()
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
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
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_19.toString()
    }
}

dependencies {
    implementation(projects.shared)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)

    implementation(libs.kodein.android)
    implementation(libs.kodein.conf)
    implementation(libs.kodein.core)

    implementation(libs.voyager.navigator)
    implementation(libs.voyager.bottom.sheet)
    implementation(libs.voyager.tab)
    implementation(libs.voyager.transitions)
    implementation(libs.voyager.androidx)
    implementation(libs.voyager.livedata)
    implementation(libs.voyager.kodein)

    implementation(libs.kotlin.serialization.json)

    implementation(libs.lyricist)
//    ksp(libs.lyricist.processor)

    implementation(libs.ktorfit.ksp)

    debugImplementation(libs.compose.ui.tooling)
}