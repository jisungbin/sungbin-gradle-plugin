/*
 * Developed by Ji Sungbin 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/jisungbin/sungbin-gradle-plugin/blob/main/LICENSE
 */

package land.sungbin.gradle.extension.config

import land.sungbin.gradle.util.SgpDsl

@SgpDsl
public class Features internal constructor() {
  private val _ktor = mutableSetOf<Ktor>()
  internal val ktor: Set<Ktor> get() = _ktor

  public enum class Ktor {
    Client, CIOEngine;

    @SgpDsl
    public class Config internal constructor() {
      internal val uses = mutableListOf<Ktor>()

      /** ktor-client-core 의존성을 추가합니다.  */
      public fun client() {
        uses += Client
      }

      /** io.ktor:ktor-client-cio 의존성을 추가합니다. */
      @Suppress("FunctionName")
      public fun CIOEngine() {
        uses += CIOEngine
      }
    }
  }

  public fun ktor(config: Ktor.Config.() -> Unit) {
    val block = Ktor.Config().apply(config)
    _ktor.addAll(block.uses)
  }
}
