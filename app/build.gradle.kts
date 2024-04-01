plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
}





android {

    namespace = "com.example.myfilsms"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myfilsms"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        externalNativeBuild {
            cmake {
                cppFlags += ""
            }
        }
        vectorDrawables {
            useSupportLibrary = true
        }

    }


    kapt {
        generateStubs = true
        correctErrorTypes = true
        arguments {arg("room.schemaLocation", "$projectDir/schemas")}
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        compose = true
        dataBinding = true
        prefab = true
    }


    composeOptions {
       // kotlinCompilerExtensionVersion = "1.6.3"
        //kotlinCompilerVersion = "1.5.3"
        kotlinCompilerExtensionVersion =  "1.5.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    ndkVersion = "25.2.9519653"
    dependenciesInfo {
        includeInBundle = true
        includeInApk = true
    }
    buildToolsVersion = "34.0.0"
}





dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0-alpha03")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.compose.material3:material3:1.2.1")
    //implementation("com.android.support:support-annotations:28.0.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    annotationProcessor("androidx.room:room-compiler-processing-testing:2.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")

    implementation("androidx.compose.ui:ui:1.7.0-alpha04")
    implementation("androidx.compose.ui:ui-graphics:1.7.0-alpha04")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation("com.google.android.material:material:1.12.0-alpha03")
    implementation ("androidx.viewpager2:viewpager2:1.1.0-beta02")
    implementation ("androidx.recyclerview:recyclerview:1.3.2")
    implementation ("jp.wasabeef:recyclerview-animators:4.0.2")
    implementation ("androidx.coordinatorlayout:coordinatorlayout:1.2.0")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.02.02"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.7.0-alpha04")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.7.0-alpha04")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.7")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    //annotationProcessor ("com.github.bump tech.glide:compiler:4.11.0")

    implementation ("com.airbnb.android:lottie:6.4.0")

    //okHttp
    implementation ("com.squareup.okhttp3:okhttp:4.12.0")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.12.0")

    //dagger
    kapt ("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.9.0")
    implementation ("com.google.dagger:dagger:2.51")
    implementation ("com.google.dagger:dagger-android:2.51")
    implementation ("com.google.dagger:dagger-android-support:2.51")
    kapt ("com.google.dagger:dagger-compiler:2.51")
    kapt ("com.google.dagger:dagger-android-processor:2.51")

    //Room
    implementation ("androidx.room:room-runtime:2.6.1") // Библиотека "Room"
    kapt ("androidx.room:room-compiler:2.6.1") // Кодогенератор
    implementation ("androidx.room:room-ktx:2.6.1") // Дополнительно для Kotlin Coroutines, Kotlin Flows

    //Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")

    //Room
    implementation ("androidx.room:room-runtime:2.6.1")
    implementation ("androidx.room:room-rxjava3:2.6.1")

//RxJava
    implementation ("io.reactivex.rxjava3:rxandroid:3.0.0")
    implementation ("io.reactivex.rxjava3:rxjava:3.0.10")
    implementation ("io.reactivex.rxjava3:rxkotlin:3.0.1")
    implementation ("com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0")


}