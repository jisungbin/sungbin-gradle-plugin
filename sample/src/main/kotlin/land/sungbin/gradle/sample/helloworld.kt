package land.sungbin.gradle.sample

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
  val client = HttpClient(CIO)
  val helloworld = client.get("https://raw.githubusercontent.com/jisungbin/jisungbin/main/helloworld.txt")
  println(helloworld.bodyAsText())
}
