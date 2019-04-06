val assertjVersion:String = ext.get("assertjVersion") as String
val junitVersion:String = ext.get("junitVersion") as String

plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":logrecorder-api"))
    implementation(kotlin("stdlib"))
    implementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")

    testImplementation("org.assertj:assertj-core:$assertjVersion")
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
