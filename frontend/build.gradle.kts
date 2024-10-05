import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.3.4"
    id("io.spring.dependency-management") version "1.1.6"

    id("org.openapi.generator") version "7.8.0"
}

task("buildPokemonClient", GenerateTask::class) {
    generatorName = "kotlin"
    inputSpec = "${projectDir.parent}/shared/specs/contract.yaml"
    outputDir = "$buildDir/generated-sources"
    modelPackage = "com.devtools.frizzer.model"
    apiPackage = "com.devtools.frizzer.api.pokemon"
    library = "jvm-spring-webclient"
    configOptions.put("serializationLibrary","jackson")
    configOptions.put("useSpringBoot3", "true")
    group = "com.devtools.frizzer.*"
}

task("buildArenaClient", GenerateTask::class) {
    generatorName = "kotlin"
    inputSpec = "${projectDir.parent}/shared/specs/arena-contract.yaml"
    outputDir = "$buildDir/generated-sources"
    modelPackage = "com.devtools.frizzer.model"
    apiPackage = "com.devtools.frizzer.api.arena"
    library = "jvm-spring-webclient"
    configOptions.put("serializationLibrary","jackson")
    configOptions.put("useSpringBoot3", "true")
    group = "com.devtools.frizzer.*"
}

task("buildTrainerClient", GenerateTask::class) {
    generatorName = "kotlin"
    inputSpec = "${projectDir.parent}/shared/specs/trainer-contract.yaml"
    outputDir = "$buildDir/generated-sources"
    modelPackage = "com.devtools.frizzer.model"
    apiPackage = "com.devtools.frizzer.api.trainer"
    library = "jvm-spring-webclient"
    configOptions.put("serializationLibrary","jackson")
    configOptions.put("useSpringBoot3", "true")
    group = "com.devtools.frizzer.*"
}

group = "com.devtools.frizzer"
version = "0.0.1-SNAPSHOT"

val springDocVersion by extra { "2.6.0" }

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")

    implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:$springDocVersion")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")


    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

sourceSets {
    main {
        kotlin {
            srcDir("$buildDir/generated-sources/src/main/kotlin")
        }
    }
}
