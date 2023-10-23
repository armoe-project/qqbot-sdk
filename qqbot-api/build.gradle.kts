plugins {
    alias(libs.plugins.kyori.blossom)
}

blossom {
    replaceToken("#VERSION#", project.version.toString())
}

dependencies {
    api(project(":qqbot-common"))

    api(libs.okhttp)
}