/*
 * Developed by Ji Sungbin 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/jisungbin/sungbin-gradle-plugin/blob/main/LICENSE
 */

@file:Suppress("INLINE_FROM_HIGHER_PLATFORM")

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

@Suppress("PrivatePropertyName")
private val EXPLICIT_API = "-Xexplicit-api=strict"

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
  getByName("main").java.srcDir("src/main/kotlin")
  getByName("test").java.srcDir("src/test/kotlin")
}

tasks.withType<Test>().configureEach {
  useJUnitPlatform()
}

tasks
  .matching { task ->
    task is KotlinCompile && !task.name.contains("test", ignoreCase = true)
  }
  .configureEach {
    if (!project.hasProperty("kotlin.optOutExplicitApi")) {
      val kotlinCompile = this as KotlinCompile
      if (EXPLICIT_API !in kotlinCompile.kotlinOptions.freeCompilerArgs) {
        kotlinCompile.kotlinOptions.freeCompilerArgs += EXPLICIT_API
      }
    }
  }

dependencies {
  implementations(
    libs.kotlin.gradle,
    libs.gradle.publish.maven,
  )
  testImplementation(libs.test.kotest.framework)
}
