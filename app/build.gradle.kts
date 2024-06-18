plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 34

    defaultConfig {
        applicationId = "healthstack.sample"
        minSdk = 29
        targetSdk = 34
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

    kapt {
        correctErrorTypes = true
    }
}

dependencies {
    val buildAppsWithSDKProject: String? by project

    if (buildAppsWithSDKProject.toBoolean()) {
        implementation(project(":kit"))
        implementation(project(":app-support"))
        implementation(project(":healthdata-link:interface"))
        implementation(project(":healthdata-link:healthconnect"))
        implementation(project(":backend-integration:interface"))
        implementation(project(":backend-integration:healthstack-adapter"))
        implementation(project(":common"))
        implementation(project(":resources:korean"))
    } else {
        implementation("io.s-healthstack:kit:${Versions.HEALTH_STACK}")
        implementation("io.s-healthstack:app-support:${Versions.HEALTH_STACK}")
        implementation("io.s-healthstack:healthdata-link:${Versions.HEALTH_STACK}")
        implementation("io.s-healthstack:healthconnect:${Versions.HEALTH_STACK}")
        implementation("io.s-healthstack:backend-integration:${Versions.HEALTH_STACK}")
        implementation("io.s-healthstack:healthstack-adapter:${Versions.HEALTH_STACK}")
        implementation("io.s-healthstack:common:${Versions.HEALTH_STACK}")
    }

    implementation(platform(AppDependencies.FIREBASE_BOM))
    implementation(AppDependencies.GOOGLE_HEALTH_CONNECT)
    implementation(AppDependencies.authImplLibs)
    implementation(AppDependencies.composeImplLibs)
    implementation(AppDependencies.hiltImplLibs)
    implementation(AppDependencies.healthDataImplLibs)
    implementation(AppDependencies.CORE_SPLASHSCREEN)
    implementation(AppDependencies.GSON)
    implementation(AppDependencies.ANDROIDX_ROOM)
    kapt(listOf(AppDependencies.ANDROIDX_ROOM_COMPILER))
    implementation(AppDependencies.ANDROIDX_ROOM_KTX)
    implementation(AppDependencies.PLAY_SERVICE_WEARABLE)

    kapt(AppDependencies.hiltKaptLibs)

    modules {
        module("org.jetbrains.kotlin:kotlin-stdlib-jdk7") {
            replacedBy("org.jetbrains.kotlin:kotlin-stdlib", "kotlin-stdlib-jdk7 is now part of kotlin-stdlib")
        }
        module("org.jetbrains.kotlin:kotlin-stdlib-jdk8") {
            replacedBy("org.jetbrains.kotlin:kotlin-stdlib", "kotlin-stdlib-jdk8 is now part of kotlin-stdlib")
        }
    }
}
