plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

dependencies {
    implementation(project(":qqbot-websocket"))
    implementation(project(":qqbot-logging"))
}

tasks.build {
    dependsOn("shadowJar")
}