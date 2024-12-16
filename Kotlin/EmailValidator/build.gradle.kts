plugins {
    kotlin("jvm") version "2.0.10"
}

group = "org.Rajabi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // https://mvnrepository.com/artifact/com.sanctionco.jmail/jmail
    implementation("com.sanctionco.jmail:jmail:1.6.3")
// https://mvnrepository.com/artifact/email-validator/email-validator
    implementation("email-validator:email-validator:0.1")

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}