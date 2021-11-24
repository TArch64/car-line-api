import java.util.Properties
import java.io.FileInputStream
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version "2.6.0"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.flywaydb.flyway") version "8.0.5"
    kotlin("jvm") version "1.6.0"
    kotlin("plugin.spring") version "1.6.0"
    kotlin("plugin.jpa") version "1.6.0"
}

group = "ua.tarch64"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web:2.6.0") {
        exclude("org.springframework.boot", "spring-boot-starter-tomcat")
    }
    implementation("org.springframework.boot:spring-boot-starter-undertow:2.6.0")
    implementation("org.springframework.boot:spring-boot-starter-validation:2.6.0")
    developmentOnly("org.springframework.boot:spring-boot-devtools:2.6.0")
    implementation("org.springframework.boot:spring-boot-starter-security:2.6.0")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.6.0")
    runtimeOnly("org.postgresql:postgresql:42.3.1")
    runtimeOnly("org.flywaydb:flyway-gradle-plugin:8.0.5")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.0")

    implementation("org.springdoc:springdoc-openapi-ui:1.5.12")
}

val applicationProperties = Properties().apply {
    load(FileInputStream("src/main/resources/application.properties"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.getByName<BootJar>("bootJar") {
    archiveFileName.set("${archiveBaseName.get()}.${archiveExtension.get()}")
}

flyway {
    url = applicationProperties.getProperty("spring.datasource.url")
    user = applicationProperties.getProperty("spring.datasource.username")
    password = applicationProperties.getProperty("spring.datasource.password")
}
