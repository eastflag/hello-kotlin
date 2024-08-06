package basic

fun main() {
    // immutable
    val school = listOf("mackerel", "trout", "halibut")
    println(school)

    // mutable
    val school2 = mutableListOf("mackerel", "trout", "halibut")
    println(school2)
    school2.remove("mackerel")
    school2.add("bbb")
    println(school2)


    val school3 = arrayOf("shark", "salmon", "minnow")
    println(java.util.Arrays.toString(school3))


}
