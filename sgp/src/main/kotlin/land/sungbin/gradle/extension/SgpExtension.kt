/*
 * Developed by Ji Sungbin 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/jisungbin/sungbin-gradle-plugin/blob/main/LICENSE
 */

package land.sungbin.gradle.extension

import land.sungbin.gradle.extension.config.Android
import land.sungbin.gradle.extension.config.Features
import land.sungbin.gradle.util.SgpDsl

@SgpDsl
public open class SgpExtension {
  internal var android = Android()
  internal var features = Features()

  public fun android(config: Android.() -> Unit) {
    android = android.apply(config)
  }

  public fun features(config: Features.() -> Unit) {
    features = features.apply(config)
  }

  // entry point for testing
  internal operator fun invoke(block: SgpExtension.() -> Unit) {
    block()
  }
}
