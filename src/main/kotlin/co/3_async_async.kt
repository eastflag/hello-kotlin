package co

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

// 코루틴은 일반적으로 CoroutineScope로 실행됩니다.
// 이렇게 하면 코루틴이 관리되지 않아 손실되는 일이 없으므로 리소스 낭비를 방지합니다.
//
// launch() 및 async()는 CoroutineScope의 확장 함수입니다.
// 범위에서 launch() 또는 async()를 호출하여 이 범위 내에서 새 코루틴을 만듭니다.
//
// CoroutineScope는 수명 주기와 연결되어 범위 내의 코루틴이 유지되는 기간에 경계를 설정합니다.
// 범위가 취소되면 작업이 취소되고 취소가 하위 작업에 전파됩니다.
// 범위의 하위 작업이 예외와 함께 실패하면 다른 하위 작업이 취소되고, 상위 작업이 취소되며, 호출자에 예외가 다시 발생합니다.

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")
//            val forecast: Deferred<String> = async {
//                getForecast()
//            }
//            val temperature: Deferred<String> = async {
//                getTemperature()
//            }
//            println("${forecast.await()} ${temperature.await()}")

            println(getWeatherReport())

            println("Have a good day!")
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}

suspend fun getWeatherReport() = coroutineScope {
    val forecast = async { getForecast() }
    val temperature = async { getTemperature() }
    "${forecast.await()} ${temperature.await()}"
}

suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}
suspend fun getTemperature(): String {
    delay(1000)
    return "30\u00b0C"
}
