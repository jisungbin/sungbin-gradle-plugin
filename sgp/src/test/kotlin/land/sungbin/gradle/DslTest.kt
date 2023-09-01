/*
 * Developed by Ji Sungbin 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/jisungbin/sungbin-gradle-plugin/blob/main/LICENSE
 */

package land.sungbin.gradle

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import land.sungbin.gradle.extension.SgpExtension
import land.sungbin.gradle.extension.config.AndroidType
import land.sungbin.gradle.extension.config.Features.Ktor

class DslTest : StringSpec() {
  init {
    "DSL로의 변경이 잘 반영됨" {
      val sgp = SgpExtension()

      sgp {
        android {
          application {
            jdkVersion = 17
          }
        }

        features {
          ktor {
            client()
            CIOEngine()
          }
        }
      }

      sgp.android.type shouldBe AndroidType.Application
      sgp.android.options.jdkVersion shouldBe 17

      sgp.features.ktor shouldContainExactly setOf(Ktor.Client, Ktor.CIOEngine)
    }
  }
}
