val kotlinVersion: String by extra("1.9.22")
val kotlinCoroutinesVersion: String by extra("1.7.3")

plugins {
  kotlin("jvm") version "1.9.22"
  kotlin("kapt") version "1.9.22"
}

allprojects {
  repositories {
    mavenCentral()
  }
}

subprojects {
  group = "app.warrior-kt"
  version = "1.0.0"

  apply(plugin = "kotlin")
  apply(plugin = "kotlin-kapt")

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

    val sourcesJar by creating(Jar::class) {
      archiveClassifier.set("sources")
      from(sourceSets.main.get().allSource)
    }

    val javadocJar by creating(Jar::class) {
      dependsOn.add(javadoc)
      archiveClassifier.set("javadoc")
      from(javadoc)
    }

    artifacts {
      archives(sourcesJar)
      archives(javadocJar)
      archives(jar)
    }
  }
}
