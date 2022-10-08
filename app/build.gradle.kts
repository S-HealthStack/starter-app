plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 32

    defaultConfig {
        applicationId = "com.samsung.healthcare.kit.sample"
        minSdk = 29
        targetSdk = 31
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.UI
    }

    packagingOptions {
        resources {
            merges += "/META-INF/LICENSE.md"
            merges += "/META-INF/NOTICE.md"
        }
    }
    namespace = "com.samsung.healthcare.kit.sample"

    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    implementation(platform(AppDependencies.FIREBASE_BOM))
    implementation(AppDependencies.authImplLibs)
    implementation(AppDependencies.composeImplLibs)
    implementation(AppDependencies.hiltImplLibs)
    implementation(AppDependencies.healthDataImplLibs)
    implementation(files("shs-libs/app-sdk-external-alpha.aar"))
    implementation(files("shs-libs/app-sdk-kit-alpha.aar"))

    kapt(AppDependencies.hiltKaptLibs)
}
