plugins {
    java
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"
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

    // Spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // DB
    implementation("org.postgresql:postgresql:42.7.2")

    // Documentation
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0")

    // Geometry
    implementation("org.locationtech.jts:jts-core:1.20.0")

    // Telegram
    implementation("org.telegram:telegrambots-springboot-longpolling-starter:7.4.0")
    implementation("org.telegram:telegrambots-client:8.0.0")



    implementation("javax.xml.bind:jaxb-api:2.3.1")

    // Lombok
    implementation("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // Testing
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
