import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val mod_version: String by project
val maven_group: String by project
val archives_base_name: String by project

plugins {
    // REMEMBER TO UPDATE LOOM VERSION HERE
    id("net.fabricmc.fabric-loom") version "1.15-SNAPSHOT"
    id("maven-publish")
    id("org.jetbrains.kotlin.jvm") version "2.3.10"
    id("com.google.devtools.ksp") version "2.3.5"

}

repositories {
    mavenLocal()
}

dependencies {
    minecraft(libs.minecraft)
    implementation(libs.fabricLoader)
    implementation(libs.fabricApi)
    implementation(libs.fabricKotlin)
    implementation(libs.carminiteApi)
    implementation(libs.torchberryAnnotations)
    ksp(libs.torchberryKSP)
}

fabricApi {
    configureDataGeneration {
        client = true
    }
}

loom {
    splitEnvironmentSourceSets()

    mods {
        create("twilight") {
            sourceSet(sourceSets.main.get())
            sourceSet(sourceSets["client"])
        }
    }
}

tasks.processResources {
    inputs.property("version", project.version)

    filesMatching("fabric.mod.json") {
        expand("version" to project.version)
    }
}


base {
    archivesName.set(archives_base_name)
}

java {
    withSourcesJar()

    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(25)
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_25)
    }
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            artifactId = archives_base_name
            from(components["java"])
        }
    }

    repositories {
        // REPOSITORIES TO PUBLISH HERE
    }
}