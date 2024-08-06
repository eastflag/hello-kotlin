package basic/*
    https://developer.android.com/codelabs/kotlin-bootcamp-functions#6
 */

fun main() {
    // lambdas is anonymous function. use ->
    var dirtyLevel = 20
    val waterFilter = { dirty : Int -> dirty / 2}
    println(waterFilter(dirtyLevel))

    val waterFilter2: (Int) -> Int = { dirty -> dirty / 2 }
    println(waterFilter2(dirtyLevel))

    // higher-order functions is to pass a lambda to another function
    println(updateDirty(30, waterFilter))

    fun increaseDirty( start: Int ) = start + 1
    // to use :: to pass named function to parameter
    println(updateDirty(15, ::increaseDirty))

    // last parameter call syntax. if lambda is parameter, you can use {} not ()
    // trailing lambda expression
    dirtyLevel = updateDirty(dirtyLevel) { dirtyLevel -> dirtyLevel + 23}
    println(dirtyLevel)
}

// a higher-order function
fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
    return operation(dirty)
}
