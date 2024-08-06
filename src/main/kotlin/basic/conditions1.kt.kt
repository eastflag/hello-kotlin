package basic

fun main() {
    val numberOfFish = 50
    val numberOfPlants = 23
    val fish = 50

    // range
    if (fish in 1..100) {
        println(fish)
    }

    // if-else 대신 when 사용
    when (numberOfFish) {
        0  -> println("Empty tank")
        in 1..39 -> println("Got fish!")
        else -> println("That's a lot of fish!")
    }
}
