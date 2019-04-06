val assertjVersion:String = ext.get("assertjVersion") as String
val junitVersion:String = ext.get("junitVersion") as String

plugins { kotlin("jvm") }

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation("org.assertj:assertj-core:$assertjVersion")
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
