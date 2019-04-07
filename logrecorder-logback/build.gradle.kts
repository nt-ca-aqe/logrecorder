import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val assertjVersion: String = ext.get("assertjVersion") as String
val logbackVersion: String = ext.get("logbackVersion") as String
val junitVersion: String = ext.get("junitVersion") as String

plugins {
    kotlin("jvm")
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

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
