/*
    https://developer.android.com/codelabs/kotlin-bootcamp-classes#3
    primary 생성자: 변수 초기화 및 init()을 호출하여 로직도 초기화
    secondary 생성자: 먼저 this()로 primary 생성자를 초기화를 한다.
    속성: get, set을 정의한다. var a; 라고 정의한다면
    xxx.a 를 하게 되면 get 호출
    var x = a 하게 되면 set 호출
 */

fun main(args: Array<String>) {
    buildAquarium()
}

fun buildAquarium() {
    // create instance. new is useless
    val aquarium1 = AquariumWithNoConstructor()
    aquarium1.printSize()

    // with constructor
    val aquarium2 = AquariumWithConstructor(width = 25)
    aquarium2.printSize()

    // with constructor and property initialization
    val aquarium3 = Aquarium(height = 35, length = 110)
    aquarium3.printSize()
    println(aquarium3.volume)  // 속성의 getter 호출
    aquarium3.volume = 11

    // init block. one or more
    // secondary constructor
    val aquarium6 = Aquarium(numberOfFish = 29)
    aquarium6.printSize()
}

class AquariumWithNoConstructor {
    var width: Int = 20
    var height: Int = 40
    var length: Int = 100

    fun printSize() {
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
    }
}

class AquariumWithConstructor(length: Int = 100, width: Int = 20, height: Int = 40) {
    // default modifier is public
    var width = width
    var height = height
    var length = length

    fun printSize() {
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
    }
}

// primary constructor: class name constructor (parameter)
class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 40) {
    // 속성과 getter and setter. getter, setter를 생략하면 컴파일러가 기본으로 생성한다.
    var volume: Int
        get() {
            println("get is called")
            return width * height * length / 1000
        }
        set(value) {
            println("set is called")
            height = (value * 1000) / (width * length)
        }

    // 인스턴스 호출시에 수행되는 초기화 메서드
    init {
        println("aquarium initializing")
    }

    // secondary constructor: constructor(parameter): initialize primary constructor
    constructor(numberOfFish: Int) : this() {
        println("second constructor initializing")
        // 2,000 cm^3 per fish + extra room so water doesn't spill
        val tank = numberOfFish * 2000 * 1.1

        height = (tank / (length * width)).toInt()
    }

    fun printSize() {
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm " + "volume: $volume l")
    }
}
