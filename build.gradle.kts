import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.21" apply false
    id("org.jetbrains.dokka") version "0.9.17" apply false
    id("maven-publish")
}

subprojects {
    ext {
        set("assertjVersion", "3.12.2")
        set("logbackVersion", "1.2.3")
        set("junitVersion", "5.4.1")
    }
}
