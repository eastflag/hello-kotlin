/*
    https://developer.android.com/codelabs/kotlin-bootcamp-functions#6
 */

fun main() {
    // function reference operator
    // named function 일 겨우 :: 가 함수 이름 앞에 필요. 만일 람다라면 ::가 필요없다.
    val trickFunction10 = trick
    val trick2Function = ::trick2

    val coins: (Int) -> String = {
        quantity -> "$quantity quarters"  // "$it quarters" 로도 가능
    }

    // 람다표현식의 입력 파라메터 매개변수 생략 가능
    // 함수의 매개변수가 한개이고 이름을 지정하지 않으면 코틀린은 암시적으로 그 매개변수이름을 it 으로 할당
    val cupcake: (Int) -> String = {
        "Have a cupcake $it"
    }
    println(cupcake(5))

    // high order 함수: parameter가 함수 이거나 리턴이 함수 인 경우
    val treatFunction = trickOrTreat(false, coins)
    val treatFunction2 = trickOrTreat(false, { "$it quarters" })  // 매개변수에 람다식 사용 예
    treatFunction()
    treatFunction2()
    val treatFunction3 = trickOrTreat(false) { "$it quarters" }  // trailing lambda expression
    treatFunction3()

    val trickFunction = trickOrTreat(true, cupcake)
    val trickFunction2 = trickOrTreat(true, null)
    trickFunction()
    trickFunction2()

    // repeat는 코틀린에서 제공하는 고차함수이다
    // for문을 간결히 표현
    println("-----")
    repeat(4) {
        println("$it")
        treatFunction()
    }
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    if (isTrick) {
        return trick
    } else {
        println(extraTreat?.let { it(5) })
        return treat
    }
}

fun trick2() {
    println("no treat")
}

// lambda expression: val [name] = {
//     function body
// }
val trick = {
    println("no treat")
}

val treat = {
    println("have a treat!")
}
