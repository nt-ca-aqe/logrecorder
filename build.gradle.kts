plugins {
    kotlin("jvm") version "1.3.21" apply false
}

allprojects {
    group = "de.novatec.logrecorder"
    version = "1.0.0-SNAPSHOT"

    ext {
        set("assertjVersion", "3.12.2")
        set("logbackVersion", "1.2.3")
        set("junitVersion", "5.4.1")
    }

    repositories {
        jcenter()
    }
}
