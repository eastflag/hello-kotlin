// https://blog.yena.io/studynote/2020/04/15/Kotlin-Scope-Functions.html

fun main(args: Array<String>) {
    // fun <T, R> T.let(block: (T) -> R): R

    val person = Person()
    val resultIt = person.let {
        it.name = "James"
        it.age = 56
        it // (T)->R 부분에서의 R에 해당하는 반환값.
    }

    val resultStr = person.let {
        it.name = "Steve"
        it.age = 59
        "${it.name} is ${it.age}" // (T)->R 부분에서의 R에 해당하는 반환값.
    }

    val resultUnit = person.let {
        it.name = "Joe"
        it.age = 63
        // (T)->R 부분에서의 R에 해당하는 반환값 없음
    }

    println("$resultIt")
    println("$resultStr")
    println("$resultUnit")

    // Safe call: 세이프콜(Safe Call, "?.")을 이용하여 객체가 null인 경우를 따로 처리해줄 수 있습니다.
    // T?.let { } 형태에서의 let 블럭 안에는 non-null 만 들어올 수 있어 non-null 체크 시에 유용하게 쓸 수 있다.
    // 객체를 선언하는 상황일 경우에는 elvis operator(?:) 를 사용해서 기본값을 지정해줄 수도 있다.
    val nameStr = person?.let { it.name } ?: "Defalut name"
    println(nameStr)
}
