//출처: https://programmmingphil.tistory.com/6 [원해성개발블로그:티스토리]
import kotlin.reflect.KProperty

class TVDelegator(var value: String) {
    operator fun getValue(home: Home2, property: KProperty<*>): String {
        println("${home.owner} $value${property.name} 사용중")
        return value
    }

    operator fun setValue(home: Home2, property: KProperty<*>, s: String) {
        println("${home.owner}이 ${value}에서 ${s}로 ${property.name}브랜드 변경 함")
        value = s
    }
}

class RoomDelegator(val value: Int) {
    operator fun getValue(home: Home2, property: KProperty<*>): Int {
        println("${home.owner}에게는 ${value}개의 ${property.name}이 있음")
        return value
    }
}

class Home2(val owner: String, _tv: String, _roomNum: Int) {
    var tv: String by TVDelegator(_tv)
    val roomNum: Int by RoomDelegator(_roomNum)
}

fun main() {
    val home = Home2("원해성", "삼성", 3)
    home.tv
    home.tv = "LG"
    home.roomNum
}
