/*
 * Developed by Ji Sungbin 2023.
 *
 * Licensed under the MIT.
 * Please see full license: https://github.com/jisungbin/sungbin-gradle-plugin/blob/main/LICENSE
 */

@file:Suppress("NOTHING_TO_INLINE", "unused")

package land.sungbin.gradle.util

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Action
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.NamedDomainObjectContainerScope
import org.gradle.kotlin.dsl.getByType

internal val Project.libs: VersionCatalog
  get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

internal fun Project.applyPlugins(vararg plugins: String) {
  plugins.forEach(pluginManager::apply)
}

internal inline operator fun <T : Any, C : NamedDomainObjectContainer<T>> C.invoke(
  configuration: Action<NamedDomainObjectContainerScope<T>>,
) =
  apply {
    configuration.execute(NamedDomainObjectContainerScope.of(this))
  }

internal val Project.androidExtensionOrNull: CommonExtension<*, *, *, *, *>?
  get() = extensions.findByName("android") as? CommonExtension<*, *, *, *, *>;

internal fun Project.implementation(dependencyNotation: Any) {
  dependencies.add("implementation", dependencyNotation)
}
