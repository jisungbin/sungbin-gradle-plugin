/*
 * Developed by Ji Sungbin 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/jisungbin/sungbin-gradle-plugin/blob/main/LICENSE
 */

plugins {
  kotlin("jvm")
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
