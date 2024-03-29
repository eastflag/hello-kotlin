package co

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

// launch() 함수로 코루틴을 실행하면 Job 인스턴스가 반환됩니다.
// Job은 코루틴에 대한 핸들 또는 참조를 보유하므로 그 수명 주기를 관리할 수 있습니다.
// val job = launch { ... }
// job.cancel()

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
            launch {
                printForecast2()
            }
            launch {
                printTemperature2()
            }
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}

suspend fun printForecast2() {
    delay(1000)
    println("Sunny")
}
suspend fun printTemperature2() {
    delay(1000)
    println("30\u00b0C")
}
