/*
  lateinit의 특징은 다음과 같습니다.
    var 프로퍼티만 사용 가능
    primitive type(Int, Boolean)은 사용할 수 없음
    Custom getter/setter를 만들 수 없음
    Non-null 프로퍼티만 사용 가능
*/
/*
  Lazy
    초기화를 미룰 수 있을 만큼 미루고 어쩔 수 없이 초기화를 해야하는 상황이 올 때 초기화를 한다
    프로퍼티를 정의할 때 초기화 코드도 함께 정의합니다.
    그리고 프로퍼티가 처음 사용될 때 초기화 구문이 실행되면서 초기값이 할당됩니다.
    초기값 대신에 by lazy { ... }를 입력하면 됩니다.
    { ... } 부분은 변수가 처음 사용될 때 한번 호출되며 마지막의 값이 초기값으로 할당됩니다.

    val 프로퍼티만 사용할 수 있음
    primitive type(Int, Boolean 등)도 사용 가능
    Non-null, Nullable 모두 사용 가능
*/

class Rectangle {
    // 늦게 초기화한다. 만일 lateinit이 생략되면 선언과 동시에 초기화되어야 한다는 에러가 발생
    lateinit var area: Area
    fun initArea(param: Area): Unit {
        this.area = param
    }
}

class Account() {
    val balance : Int by lazy {
        println("Setting balance!")
        100
    }
}

class Area(val value: Int)

fun main() {
    // lateinit example
    val rectangle = Rectangle()
    rectangle.initArea(Area(10))
    println(rectangle.area.value)

    // lazy example // account.balance로 get을 할때 lazy의 초기화 블럭이 실행. 마지막 100이 리턴, 단 한번만 실행
    val account = Account()
    println(account.balance)
    println(account.balance)
}
