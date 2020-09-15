import org.gradle.jvm.tasks.Jar

val assertjVersion: String = ext.get("assertjVersion") as String
val logbackVersion: String = ext.get("logbackVersion") as String
val junitVersion: String = ext.get("junitVersion") as String

val javaComponent = components["java"] as AdhocComponentWithVariants

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.dokka")
    id("maven-publish")
}

repositories {
    jcenter()
}

dependencies {
    implementation(project(":logrecorder-api"))
    implementation(project(":logrecorder-assertion"))
    implementation(kotlin("stdlib"))

    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    implementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")

    testImplementation("org.assertj:assertj-core:$assertjVersion")
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

tasks {

    compileKotlin { kotlinOptions { jvmTarget = "1.8" } }
    compileTestKotlin { kotlinOptions { jvmTarget = "1.8" } }

    dokka { outputFormat = "html"; outputDirectory = "$buildDir/javadoc" }

    test { useJUnitPlatform() }

    val sourcesJar by creating(Jar::class) {
        dependsOn(classes)
        archiveClassifier.set("sources")
        from(sourceSets["main"].allSource)
    }

    val javadocJar by creating(Jar::class) {
        dependsOn(dokka)
        archiveClassifier.set("javadoc")
        from(dokka)
    }

    artifacts {
        add("archives", sourcesJar)
        add("archives", javadocJar)
    }

    publishing {
        publications {
            create<MavenPublication>("default") {
                from(javaComponent)
                artifact(sourcesJar)
                artifact(javadocJar)
            }
        }
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
