plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":logrecorder-api"))
    implementation(kotlin("stdlib"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.1")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
