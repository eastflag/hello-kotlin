package basic

fun main() {
    var fishFoodTreats = 6
    // fishFoodTreats 가 null 이 아니면 dec() null 이면 0
    fishFoodTreats = fishFoodTreats?.dec() ?: 0

    println(fishFoodTreats)

    // non-null operator (double bang)
    var s: String? = "abc"
    val len = s!!.length   // throws NullPointerException if s is null

    println(len)
}
