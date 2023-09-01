/*
 * Developed by Ji Sungbin 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/jisungbin/sungbin-gradle-plugin/blob/main/LICENSE
 */

@file:Suppress("unused")

package land.sungbin.gradle.util

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.JavaVersion

/** 주어진 JDK 버전으로 `sourceCompatibility`와 `targetCompatibility`를 지정합니다. */
public fun CommonExtension<*, *, *, *, *>.jdkVersion(version: Int) {
  JavaVersion.toVersion(version).let { javaVersion ->
    compileOptions {
      sourceCompatibility = javaVersion
      targetCompatibility = javaVersion
    }
  }
}
