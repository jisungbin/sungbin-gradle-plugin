/*
 * Developed by Ji Sungbin 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/jisungbin/sungbin-gradle-plugin/blob/main/LICENSE
 */

@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

plugins {
  `kotlin-dsl`
  id(libs.plugins.kotlin.jvm.get().pluginId)
}

gradlePlugin {
  plugins {
//    register(pluginName) {
//      implementationClass = className
//      id = "sungbin.gradle.$pluginName"
//    }
  }
}

java {
  sourceCompatibility = JavaVersion.VERSION_17
  targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
  jvmToolchain(17)
}

sourceSets {
  getByName("main").java.srcDirs("src/main/kotlin")
  getByName("test").java.srcDirs("src/test/kotlin")
}

tasks.withType<Test>().configureEach {
  useJUnitPlatform()
}

dependencies {
  implementations(
    libs.kotlin.gradle,
    libs.gradle.publish.maven,
  )
  testImplementation(libs.test.kotest.framework)
}
