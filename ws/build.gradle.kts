plugins {
    id("java")
    id("java-library")
    id("org.springframework.boot")
}

val springBootVersion: String by project
val lombokVersion: String by project
val mapstructVersion: String by project

group = "sc"
version = "0.0.1"

apply {
    plugin("java")
    plugin("java-library")
}

repositories {
    mavenCentral()
    jcenter()
    maven {
        url = uri("https://repo.spring.io/milestone")
    }
}

tasks.withType<JavaCompile> {
    sourceCompatibility = "14"
    targetCompatibility = "14"

    val compilerArgs = options.compilerArgs
    compilerArgs.add("-Amapstruct.unmappedTargetPolicy=IGNORE")
    compilerArgs.add("-Amapstruct.defaultComponentModel=spring")
}

dependencies {
    //BOM
    api(platform("org.springframework.boot:spring-boot-dependencies:$springBootVersion"))

    compileOnly("org.mapstruct:mapstruct-jdk8:$mapstructVersion")
    annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")

    compileOnly("org.projectlombok:lombok:$lombokVersion")
    annotationProcessor("org.projectlombok:lombok:$lombokVersion")

    implementation("org.springframework.boot:spring-boot-starter-web")

}