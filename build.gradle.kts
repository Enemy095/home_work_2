plugins {
    id("java")
}

group = "org.work"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")


    /**
     * Utils & Logging
     */
    compileOnly("org.project lombok:lombok")
    annotationProcessor("org.project lombok:lombok")
}

tasks.test {
    useJUnitPlatform()
}