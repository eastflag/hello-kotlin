import java.util.*

fun main(args: Array<String>) {
    // template string

    // var and val
    var a = "111"
    a = a.substring(0, a.length-1)
    println(a)

    for (i in 1..10) {
        var r = Random().nextInt(7)
        println(r)
    }
}
