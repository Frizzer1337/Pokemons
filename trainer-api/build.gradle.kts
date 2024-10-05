import org.openapitools.generator.gradle.plugin.tasks.GenerateTask

plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    kotlin("plugin.jpa") version "1.9.25"

    id("org.openapi.generator") version "7.8.0"
    id("org.springframework.boot") version "3.3.3"
    id("io.spring.dependency-management") version "1.1.6"
}

task("buildServer",GenerateTask::class) {
    generatorName = "kotlin-spring"
    inputSpec = "${projectDir.parent}/shared/specs/trainer-contract.yaml"
    outputDir = "$buildDir/generated-sources"
    apiPackage = "com.devtools.frizzer.api"
    invokerPackage = "com.devtools.frizzer.invoker"
    modelPackage = "com.devtools.frizzer.model"
    packageName = "com.devtools.frizzer"
    configOptions.put("useSpringBoot3", "true")
    configOptions.put("reactive", "true")
    configOptions.put("serverPort", "8001")
    group = "com.devtools.frizzer.*"
    generateApiTests = false
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

extra["springCloudVersion"] = "2023.0.3"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")

    implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:$springDocVersion")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")


    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("org.postgresql:r2dbc-postgresql")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
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
