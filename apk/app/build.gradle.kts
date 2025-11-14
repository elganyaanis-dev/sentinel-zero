plugins {
    id("com.android.application") version "8.4.0"
    kotlin("android") version "2.0.0"
}
android {
    namespace = "com.sentinel.zero"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.sentinel.zero"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "0.1.0"
    }
    signingConfigs {
        create("release") {
            storeFile = file("../keystore.jks")
            storePassword = System.getenv("KSP")
            keyAlias = "sentinel"
            keyPassword = System.getenv("KSP")
        }
    }
    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
        }
    }
}
dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("org.java-websocket:Java-WebSocket:1.5.6")
    implementation("com.google.android.play:core:1.10.3")
}
