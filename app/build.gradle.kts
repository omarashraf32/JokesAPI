plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs") //navigation&safeargs(pass data between destination)
}

android {
    namespace = "com.example.retrofitapi"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.retrofitapi"
        minSdk = 24
        targetSdk = 33
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    //Gson
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    //Declaring dependencies (activity)
    implementation("androidx.activity:activity-ktx:1.8.0")
    //Declaring dependencies (fragment)
    implementation("androidx.fragment:fragment-ktx:1.6.2")
    // Retrofit with RX Java
    implementation ("com.squareup.retrofit2:adapter-rxjava3:2.9.0")
    //Retrofit Interceptors + OkHttp3
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    //Logging Interceptor
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
    //javax inject library
    implementation ("javax.inject:javax.inject:1")




}