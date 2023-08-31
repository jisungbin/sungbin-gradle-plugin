/*
 * Developed by Ji Sungbin 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/jisungbin/sungbin-gradle-plugin/blob/main/LICENSE
 */

@file:Suppress("UnstableApiUsage")

rootProject.name = "sgp"

enableFeaturePreview("STABLE_CONFIGURATION_CACHE")

pluginManagement {
  repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
  }
}

buildCache {
  local {
    removeUnusedEntriesAfterDays = 7
  }
}

include(":sgp")
