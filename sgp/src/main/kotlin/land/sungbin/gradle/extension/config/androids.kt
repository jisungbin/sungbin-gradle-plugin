/*
 * Developed by Ji Sungbin 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/jisungbin/sungbin-gradle-plugin/blob/main/LICENSE
 */

package land.sungbin.gradle.extension.config

import land.sungbin.gradle.util.SgpDsl

/** SGP에서 구성 가능한 안드로이드 요소 모음 */
@SgpDsl
public class Android internal constructor() {
  private var _isKotlinSourceSet = false
  internal val isKotlinSourceSet get() = _isKotlinSourceSet

  /**
   * SourceSet에 Kotlin을 추가합니다.
   *
   * 추가되는 영역은 다음과 같습니다:
   * main, test, androidTest
   */
  public fun kotlinSourceSet() {
    _isKotlinSourceSet = true
  }
}
