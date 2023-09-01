<p align="center">
  <img src="https://avatars.githubusercontent.com/u/40740128" width="25%" alt="jisungbin" />
</p>
<h1 align="center">Sungbin Gradle Plugin</h1>

---

![version](https://img.shields.io/maven-central/v/land.sungbin/sungbin-gradle-plugin?style=flat-square)

```kotlin
plugins { id("land.sungbin.gradle") }
android { jdkVersion(17) }

sgp {
  android { kotlinSourceSet() }
  features {
    ktor { client(); CIOEngine() }
  }
}
```
