//출처: https://programmmingphil.tistory.com/6 [원해성개발블로그:티스토리]

class Home1(private val _tv: String, private val _roomNum: Int) {
    var tv: String = _tv
        get() {
            println("$_tv TV 사용중")
            return field
        }
        set(value) {
            println("${_tv}에서 ${value}로 브랜드변경됨")
            field = value
        }

    val roomNum: Int = _roomNum
        get() {
            println("${_roomNum}개의 방이 있음")
            return field
        }
}

fun main() {
    val home = Home1("삼성", 3)
    home.tv
    home.tv = "LG"
    home.roomNum
}
