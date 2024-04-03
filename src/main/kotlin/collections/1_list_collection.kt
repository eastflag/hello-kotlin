package collections

fun main() {
    val solarList = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    for (solar in solarList) {
        println(solar)
    }

    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")

    solarSystem.add("aaa")
}
