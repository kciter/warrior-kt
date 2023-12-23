plugins {
    kotlin("jvm") version "1.9.0"
}

allprojects {
    repositories {
        mavenCentral()
    }
}

group = "app.warrior-kt"
version = "1.0-SNAPSHOT"

subprojects {
    apply {
        plugin("kotlin")
    }

    dependencies {
        testImplementation(kotlin("test"))
    }

    tasks {
        compileKotlin {
            kotlinOptions {
                jvmTarget = "17"
            }
        }

        compileTestKotlin {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }
}
