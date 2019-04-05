plugins {
    java
}

tasks.withType(Wrapper::class) {
    gradleVersion = "5.2.1"
}

group = "com.example"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.4.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.4.1")

    //like we have dependency hell
    testImplementation("org.junit.platform:junit-platform-commons:1.3.2")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}