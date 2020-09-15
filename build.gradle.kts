plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.21" apply false
    id("org.jetbrains.dokka") version "0.9.17" apply false
    id("maven-publish")
}

subprojects {
    apply { plugin("maven-publish") }
    ext {
        set("assertjVersion", "3.12.2")
        set("logbackVersion", "1.2.3")
        set("junitVersion", "5.4.1")
    }
    publishing {
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/nt-ca-aqe/logrecorder")
                credentials {
                    username = System.getenv("USERNAME")
                    password = System.getenv("TOKEN")
                }
            }
        }
    }
}
