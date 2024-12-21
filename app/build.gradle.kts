plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.ktck124.lop124LTDD04.nhom13"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ktck124.lop124LTDD04.nhom13"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation ("com.github.bumptech.glide:glide:4.16.0")
    implementation ("com.codesgood:justifiedtextview:1.1.0")
    implementation ("me.relex:circleindicator:2.1.6")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")

    implementation(platform("com.google.firebase:firebase-bom:33.6.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-database")
    implementation ("com.google.firebase:firebase-database:20.4.2")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    annotationProcessor ("com.github.bumptech.glide:compiler:4.16.0")
}