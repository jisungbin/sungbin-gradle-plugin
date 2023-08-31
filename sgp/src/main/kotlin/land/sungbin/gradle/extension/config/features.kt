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
  internal var moshi = false
  internal var moshix = emptySet<MoshiX>()

  public enum class MoshiX {
    IR;

    @SgpDsl
    public class Config internal constructor() {
      internal val uses = mutableListOf<MoshiX>()

      public fun ir() {
        uses += IR
      }
    }
  }

  public fun moshi() {
    moshi = true
  }

  public fun moshix(config: MoshiX.Config.() -> Unit) {
    val result = MoshiX.Config().apply(config)
    moshix = moshix.toMutableSet().apply { addAll(result.uses) }
  }
}