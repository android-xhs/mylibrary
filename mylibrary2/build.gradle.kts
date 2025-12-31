plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "com.xhs.mylibrary2"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        minSdk = 26

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
afterEvaluate {
    publishing {
        publications {
            // 创建一个名为 “release” 的发布配置
            create<MavenPublication>("release") {
                // 指定要发布的组件（通常是 release 版本的 AAR包）
                from(components["release"])

                // 配置 Maven 坐标，这是其他项目引用你的库时的唯一标识
                groupId = "com.github.andorid-xhs" // 通常是你的 GitHub 用户名或组织名，可以为包名
                artifactId = "mylibrary2" // 库的名称，通常与模块名一致
                version = project.extra["appVersion"] as? String // 版本号，jitpack将使用tag标签，这里是设置一个默认值
            }
        }
    }
}
