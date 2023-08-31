/*
 * Developed by Ji Sungbin 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/jisungbin/sungbin-gradle-plugin/blob/main/LICENSE
 */

package land.sungbin.gradle.extension.config

import land.sungbin.gradle.util.SgpDsl
import org.gradle.api.JavaVersion

public enum class AndroidType {
  Application, Library,
}

@SgpDsl
public class Android {
  internal var type: AndroidType? = null
  internal val options = AndroidOptions()

  public fun application(options: AndroidOptions.() -> Unit) {
    type = AndroidType.Application
    options.invoke(this.options)
  }

  public fun library(options: AndroidOptions.() -> Unit) {
    type = AndroidType.Library
    options.invoke(this.options)
  }
}

public class AndroidOptions {
  public var jdkVersion: JavaVersion = JavaVersion.VERSION_17
}