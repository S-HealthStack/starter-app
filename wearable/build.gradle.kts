plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("io.gitlab.arturbosch.detekt")
}

android {
    namespace = "healthstack.sample"
    compileSdk = 34

    defaultConfig {
        applicationId = "healthstack.sample"
        minSdk = 29
        targetSdk = 34

        vectorDrawables {
            useSupportLibrary = true
        }
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
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    val buildAppsWithSDKProject: String? by project

    if (buildAppsWithSDKProject.toBoolean()) {
        implementation(project(":common"))
        implementation(project(":wearable-kit"))
        implementation(project(":wearable-support"))
    } else {
        implementation("io.s-healthstack:common:${Versions.HEALTH_STACK}")
        implementation("io.s-healthstack:wearable-kit:${Versions.HEALTH_STACK}")
        implementation("io.s-healthstack:wearable-support:${Versions.HEALTH_STACK}")
    }

    // locate sdk file in libs: https://developer.samsung.com/health/privileged
    implementation(fileTree("libs"))

    implementation(AppDependencies.PLAY_SERVICE_WEARABLE)
    implementation(AppDependencies.androidXImplLibsWearable)
    implementation(AppDependencies.composeImplLibsWearable)
    implementation(AppDependencies.hiltImplLibs)
    implementation(AppDependencies.GSON)
    implementation(AppDependencies.WEAR_APPCOMPAT)
    implementation(AppDependencies.WEAR_MATERIAL)
    implementation(AppDependencies.WEAR_CONST_LAYOUT)
    implementation(AppDependencies.WEAR_TEST_MONITOR)
    debugImplementation(AppDependencies.uiDebugLibsWearable)
    kapt(AppDependencies.hiltKaptLibs)

    // Room
    implementation(AppDependencies.roomLibs)
    kapt(listOf(AppDependencies.ANDROIDX_ROOM_COMPILER))

    // Unit Test
    testImplementation(AppDependencies.JUNIT)
    testImplementation(AppDependencies.testImplLibs)

    modules {
        module("org.jetbrains.kotlin:kotlin-stdlib-jdk7") {
            replacedBy("org.jetbrains.kotlin:kotlin-stdlib", "kotlin-stdlib-jdk7 is now part of kotlin-stdlib")
        }
        module("org.jetbrains.kotlin:kotlin-stdlib-jdk8") {
            replacedBy("org.jetbrains.kotlin:kotlin-stdlib", "kotlin-stdlib-jdk8 is now part of kotlin-stdlib")
        }
    }
}
