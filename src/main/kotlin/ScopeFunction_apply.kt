// public inline fun <T> T apply(block: T.() -> Unit): T
// apply는 수신객체 내부 프로퍼티를 변경한 다음 수신객체 자체를 반환하기 위해 사용되는 함수
// 객체 생성시에 다양한 프로퍼티를 설정해야 하는 경우 자주 사용

data class Person(
    var name: String = "",
    var age: Int = 0,
    var temperature: Float = 36.5f
)

fun main(args: Array<String>) {
    val person = Person().apply {
        name = "DevCho"
        age = 20
        temperature = 36.2f
    }
}
