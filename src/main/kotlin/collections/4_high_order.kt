package collections

class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main() {
    // forEach로 모든 요소 출력
    cookies.forEach {
        println("$it, ${it.name}")
    }

    // map
    val mapList = cookies.map {
        "${it.name} - $${it.price}"
    }
    println(mapList)

    val filterList = cookies.filter {
        it.softBaked
    }
    println(filterList)

    // groupby
    val groupedMenu = cookies.groupBy {
        it.softBaked
    }
    // key가 false, true인 Map 리턴
    println(groupedMenu)
    val softBakedMenu = groupedMenu[true] ?: listOf()
    println(softBakedMenu)

    // fold: 다른 언어의 reduce와 동일
    val totalPrice = cookies.fold(0.0) {total, cookie ->
        total + cookie.price
    }
    println(totalPrice)

    // sortedBy
    val alphabeticalMenu = cookies.sortedBy {
        it.name
    }
    alphabeticalMenu.forEach { println("${it.name}") }
}
