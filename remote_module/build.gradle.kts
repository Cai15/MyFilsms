@file:Suppress("UNUSED_EXPRESSION")

plugins {
    id ("com.android.library")
    id ("kotlin-android")
    id ("kotlin-kapt")
    apply { "versions.gradle" }
}



android {
    namespace = "com.example.remote_module"
    compileSdk = 34

    defaultConfig {
        minSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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

}

dependencies {

    implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.9.21")
    implementation ("androidx.core:core-ktx:1.12.0")
    implementation ("androidx.appcompat:appcompat:1.6.1")
    implementation ("com.google.android.material:material:1.11.0")
    implementation("androidx.test.ext:junit-ktx:1.1.5")
    implementation(project(":app"))
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("junit:junit:4.13.2")

    //Dagger
    kapt ("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.9.0")
    implementation ("com.google.dagger:dagger:2.51")
    implementation ("com.google.dagger:dagger-android:2.51")
    implementation ("com.google.dagger:dagger-android-support:2.51")
    kapt ("com.google.dagger:dagger-compiler:2.51")
    kapt ("com.google.dagger:dagger-android-processor:2.51")

            //Retrofit
            implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation ("com.github.akarnokd:rxjava3-retrofit-adapter:3.0.0")
    implementation ("io.reactivex.rxjava3:rxjava:3.0.10")
}