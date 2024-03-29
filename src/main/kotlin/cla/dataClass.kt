/*
  data class: toString(), hashCode(), equals(), copy()메소드를 자동으로 만들어주는 클래스
    상속 받을 수 없습니다.
    val 또는 var으로 선언해야 합니다
    abstract, open, sealed, inner를 붙일 수 없습니다
    1개 이상의 프로퍼티를 가지고 있어야 합니다
    equals(), toString(), hashCode()에 Override 구현 시 구현 함수를 사용합니다.
 */

package cla

fun main(args: Array<String>) {
    val user1 = User("Kenneth", "https://store.image/profile_1", 30)
    val user2 = user1.copy(name = "scarlet")

    println(user1.name)
    println(user2.toString())
}

data class User(
    val name: String,
    val profileImg: String,
    val age: Int
) {
    val weight: Int = 80
}
