/*
    https://developer.android.com/codelabs/kotlin-bootcamp-functions#6
 */

fun main() {
    // function reference operator
    val trick2Function = ::trick2

    val coins: (Int) -> String = {
        quantity -> "$quantity quarters"  // "$it quarters" 로도 가능
    }

    // 람다표현식의 입력 파라메터 매개변수 생략 가능
    val cupcake: (Int) -> String = {
        "Have a cupcake"
    }

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

    repeat(4) {
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
