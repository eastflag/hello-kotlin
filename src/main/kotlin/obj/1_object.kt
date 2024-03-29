package obj

// object 는 객체, 최초 선언시 자동으로 생성, 이후에는 코드 전체에서 공용으로 사용
// => singleton 객체
// class 없이 인스턴스를 만들때 사용

fun main() {
    println(Counter.count)

    Counter.countUp()
    Counter.countUp()

    println(Counter.count)

    Counter.clear()

    println(Counter.count)
}

object Counter {
    var count = 0

    fun countUp() {
        count++
    }

    fun clear() {
        count = 0
    }
}
