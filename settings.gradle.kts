pluginManagement {
    val springBootVersion: String by settings

    plugins {
        id("org.springframework.boot") version springBootVersion apply false
    }
}

rootProject.name = "smart-cafe-mvp"

include("ws")
include("ui")