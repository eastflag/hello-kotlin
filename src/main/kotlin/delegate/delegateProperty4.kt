package delegate

import kotlin.properties.Delegates

class Home4(tv: String, roomNum: Int) {
    var tv: String by Delegates.observable(tv) { property, oldValue, newValue ->
        println("${property.name} ${oldValue}에서 ${newValue}로 변경됨")
    }

    var roomNum : Int by Delegates.observable(roomNum) { property, oldValue, newValue ->
        println("${property.name} ${oldValue}에서 ${newValue}로 변경됨")
    }
}

fun main() {
    val home = Home4("삼성",4)

    home.tv = "LG"
    home.roomNum = 5
}
