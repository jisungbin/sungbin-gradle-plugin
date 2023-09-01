import land.sungbin.gradle.util.jdkVersion

/*
 * Developed by Ji Sungbin 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/jisungbin/sungbin-gradle-plugin/blob/main/LICENSE
 */

plugins {
  id("com.android.library")
  id("land.sungbin.gradle") version "0.1.0"
}

android {
  namespace = "sungbin.gradle.sample.helloworld"
  jdkVersion(17)
}

sgp {
  android {
    kotlinSourceSet()
  }
  features {
    ktor {
      client()
      CIOEngine()
    }
  }
}
