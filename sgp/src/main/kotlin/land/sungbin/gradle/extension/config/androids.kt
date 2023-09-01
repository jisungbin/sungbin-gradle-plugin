/*
 * Developed by Ji Sungbin 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/jisungbin/sungbin-gradle-plugin/blob/main/LICENSE
 */

package land.sungbin.gradle.extension.config

import land.sungbin.gradle.util.SgpDsl

@SgpDsl
public class Android internal constructor() {
  private var _isKotlinSourceSet = false
  internal val isKotlinSourceSet get() = _isKotlinSourceSet

  public fun kotlinSourceSet() {
    _isKotlinSourceSet = true
  }
}
