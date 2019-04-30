plugins {
    application
}

group = "com.coderbunker"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    testCompile(group = "junit", name = "junit", version = "4.12")
}
