// 출처: https://programmmingphil.tistory.com/6 [원해성개발블로그:티스토리]

class Home3(_tv: String) {
    var tv: String = _tv
        get() {
            println("$field 티비")
            return field
        }

        set(value) {
            println("$field 티비 -> $value 티비")
            field = value
        }
}

fun main() {
    val home1 = Home3("삼성")
    val home2 : Home3 by lazy {
        Home3("LG")
    }

    home1.tv
    home1.tv = "애플"

    home2.tv
    home2.tv = "애플"
}
