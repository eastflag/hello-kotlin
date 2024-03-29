package co

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

// coroutine 2 개중 하나라도 실패하면 처리를 안하도록 예외처리

fun main() {
    val time = measureTimeMillis {
        runBlocking {
            println("Weather forecast")

            try {
                println(getWeatherReport2())
            } catch (e: AssertionError) {
                println("Caught exception in runBlocking(): $e")
                println("Report unavailable at this time")
            }

            println("Have a good day!")
        }
    }
    println("Execution time: ${time / 1000.0} seconds")
}

suspend fun getWeatherReport2() = coroutineScope {
    val forecast = async { getForecast2() }
    val temperature = async { getTemperature2() }
    "${forecast.await()} ${temperature.await()}"
}

suspend fun getForecast2(): String {
    delay(1000)
    return "Sunny"
}
suspend fun getTemperature2(): String {
    delay(500)
    throw AssertionError("Temperature is invalid")
    return "30\u00b0C"
}
