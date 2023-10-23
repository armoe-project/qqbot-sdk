import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.kotlin.jvm)
}

allprojects {
    group = "me.zhenxin"
    version = "2.0.0-dev"
}

subprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}


