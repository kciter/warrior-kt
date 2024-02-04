val artifactId = "warrior-kt-core"
val kotlinVersion: String by rootProject.extra

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVersion")

  implementation("org.jetbrains.kotlin:kotlin-scripting-common:$kotlinVersion")
  implementation("org.jetbrains.kotlin:kotlin-scripting-jvm:$kotlinVersion")
  implementation("org.jetbrains.kotlin:kotlin-scripting-jvm-host:$kotlinVersion")
  implementation("org.jetbrains.kotlin:kotlin-scripting-dependencies:$kotlinVersion")
  implementation("org.jetbrains.kotlin:kotlin-scripting-dependencies-maven:$kotlinVersion")
}
