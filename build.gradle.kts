plugins {
    java
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
    id ("java")
    id ("com.github.node-gradle.node") version "3.5.1" // Node.js плагин
}

group = "com.radaev"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    annotationProcessor("org.projectlombok:lombok")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")
    implementation("org.postgresql:postgresql:42.7.2")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation ("org.locationtech.jts:jts-core:1.20.0")
}
node{
    version = "18.17.1"
    npmVersion = "9.6.7"
    download = true
    workDir = file("${project.buildDir}/nodejs")
    nodeModulesDir = file("frontend")
}


tasks.withType<Test> {
    useJUnitPlatform()
}
