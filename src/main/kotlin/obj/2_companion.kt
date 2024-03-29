package obj

// class안에 companion object 사용시 공용 속성 및 함수
// 자바의 static과 유사
fun main() {
    var a = FoodPoll(name = "pizza")
    var b = FoodPoll(name = "ramen")

    a.vote()
    a.vote()

    b.vote()
    b.vote()
    b.vote()

    println("${a.count}, ${b.count} ${FoodPoll.total}")
}

class FoodPoll (val name: String) {
    companion object {
        var total = 0
    }

    var count = 0

    fun vote() {
        total++
        count++
    }
}
