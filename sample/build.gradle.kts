/*
 * Developed by Ji Sungbin 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/jisungbin/sungbin-gradle-plugin/blob/main/LICENSE
 */

plugins {
  id(libs.plugins.kotlin.jvm.get().pluginId)
  id("land.sungbin.gradle") version "0.1.0"
}

sgp {
  features {
    ktor {
      client()
      CIOEngine()
    }
  }
}

dependencies {
  implementation(libs.kotlinx.coroutines)
}
