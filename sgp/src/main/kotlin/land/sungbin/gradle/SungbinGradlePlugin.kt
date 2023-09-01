/*
 * Developed by Ji Sungbin 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/jisungbin/sungbin-gradle-plugin/blob/main/LICENSE
 */

package land.sungbin.gradle

import land.sungbin.gradle.extension.SgpExtension
import land.sungbin.gradle.extension.config.Features.Ktor
import land.sungbin.gradle.util.androidExtensionOrNull
import land.sungbin.gradle.util.implementation
import land.sungbin.gradle.util.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create

private const val SgpExtensionName = "sgp"

/** Entry point of SungbinGradlePlugin. */
public class SungbinGradlePlugin : Plugin<Project> {
  override fun apply(project: Project) {
    with(project) {
      val sgp = extensions.create<SgpExtension>(SgpExtensionName)

      afterEvaluate {
        for (ktor in sgp.features.ktor) {
          when (ktor) {
            Ktor.Client -> implementation(libs.findLibrary("ktor-client-core").get())
            Ktor.CIOEngine -> implementation(libs.findLibrary("ktor-client-engine-cio").get())
          }
        }

        with(sgp.android) {
          androidExtensionOrNull?.apply {
            if (isKotlinSourceSet) {
              sourceSets {
                getByName("main").java.srcDir("src/main/kotlin")
                getByName("test").java.srcDir("src/test/kotlin")
                getByName("androidTest").java.srcDir("src/androidTest/kotlin")
              }
            }
          }
        }
      }
    }
  }
}
