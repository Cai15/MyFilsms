import org.gradle.internal.impldep.org.jsoup.safety.Safelist.basic

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("com.google.firebase.firebase-perf")
}
apply(from = "D:\\Ucheba\\MyFilsms\\versions.gradle.kt")







android {

    namespace = "com.example.myfilsms"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myfilsms"
        minSdk = 31
        //noinspection OldTargetApi,EditedTargetSdkVersion
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
        flavorDimensions += "version"
        productFlavors {
            create ("basic") {
                dimension = "version"
                applicationIdSuffix = ".basic"
                versionNameSuffix = "-basic"
            }
            create ("pro") {
                dimension = "version"
                applicationIdSuffix = ".pro"
                versionNameSuffix = "-pro"
            }
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
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
        kotlinCompilerExtensionVersion =  "1.5.11"
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
    sourceSets {
        getByName("basic") {
            java {
                srcDirs("src\\basic\\java", "src\\basic\\java",
                    "src\\basic\\java"
                )
            }
        }
        getByName("pro") {
            java {
                srcDirs("src\\pro\\java", "src\\pro\\java",
                    "src\\pro\\java"
                )
            }
        }
    }
}





dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0-rc01")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation(project(":remote_module"))
    implementation("com.google.firebase:firebase-perf:21.0.1")
    implementation("com.google.firebase:firebase-config:22.0.0")

    annotationProcessor("androidx.room:room-compiler-processing-testing:2.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.cardview:cardview:1.0.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")

    implementation("androidx.compose.ui:ui:1.7.0-alpha06")
    implementation("androidx.compose.ui:ui-graphics:1.7.0-alpha06")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation("com.google.android.material:material:1.12.0-rc01")
    implementation ("androidx.viewpager2:viewpager2:1.1.0-beta02")
    implementation ("androidx.recyclerview:recyclerview:1.3.2")
    implementation ("jp.wasabeef:recyclerview-animators:4.0.2")
    implementation ("androidx.coordinatorlayout:coordinatorlayout:1.2.0")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.04.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.7.0-alpha06")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.7.0-alpha06")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.7")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")


    implementation ("com.airbnb.android:lottie:6.4.0")

    //okHttp
    implementation ("com.squareup.okhttp3:okhttp:4.12.0")

    //Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.11.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.11.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.12.0")

    //dagger
   /* kapt ("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.9.0")
    implementation ("com.google.dagger:dagger:2.51.1")
    implementation ("com.google.dagger:dagger-android:2.51.1")
    implementation ("com.google.dagger:dagger-android-support:2.51.1")
    kapt ("com.google.dagger:dagger-compiler:2.51.1")
    kapt ("com.google.dagger:dagger-android-processor:2.51.1")*/
    implementation ("${property("dagger")}")
    kapt("${property("daggerCompiler")}")

    //Room
    implementation ("androidx.room:room-runtime:2.6.1") // Библиотека "Room"
    //noinspection KaptUsageInsteadOfKsp
    kapt ("androidx.room:room-compiler:2.6.1") // Кодогенератор
    implementation ("androidx.room:room-ktx:2.6.1") // Дополнительно для Kotlin Coroutines, Kotlin Flows

    //Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")

    //Room
    implementation ("androidx.room:room-runtime:2.6.1")
    implementation ("androidx.room:room-rxjava3:2.6.1")

//RxJava
    implementation ("io.reactivex.rxjava3:rxandroid:3.0.2")
    implementation ("io.reactivex.rxjava3:rxjava:3.1.8")
    implementation ("io.reactivex.rxjava3:rxkotlin:3.0.1")
    implementation ("com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0")

    //Remote module
    project(":remote_module")

    //Ошибки Pendding
    implementation ("androidx.work:work-runtime-ktx:2.9.0")

    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:33.1.0"))

    // When using the BoM, you don't specify versions in Firebase library dependencies

    // Add the dependency for the Firebase SDK for Google Analytics
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-crashlytics")

    // TODO: Add the dependencies for any other Firebase products you want to use
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-firestore")


}