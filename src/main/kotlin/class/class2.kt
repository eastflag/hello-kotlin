/*
    https://developer.android.com/codelabs/kotlin-bootcamp-classes#4
    상속의 수퍼 클래스가 되기 위해서는 class 앞에 open을 추가
    서브 클래스는 : superClass() 형식으로 수퍼클래스의 생성자를 호출해야 한다.
    오버라이딩과:
      수퍼클래스에 선언된 메서드, 속성과 동일한 이름을 서브클래스에서 사용할수 없다.
      사용하기 위해서는 수퍼클래스에는 open, 서브클래스에는 override를 붙인다.
 */

import java.lang.Math.PI

fun main(args: Array<String>) {
//    buildAquarium2()

    val towerTank = TowerTank(height = 45, diameter = 45)
    towerTank.printSize()
}

fun buildAquarium2() {
    val aquarium6 = Aquarium2(length = 25, width = 25, height = 40)
    aquarium6.printSize()
}

// kotlin은 모든 클래스가 최종. 확장하기 위해서 open
open class Aquarium2 (open var length: Int = 100, open var width: Int = 20, open var height: Int = 40) {
    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    open val shape = "rectangle"

    open var water: Double = 0.0
        get() = volume * 0.9

    fun printSize() {
        println(shape)
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
        // 1 l = 1000 cm^3
        println("Volume: $volume l Water: $water l (${water/volume*100.0}% full)")
    }
}

class TowerTank(override var height: Int, var diameter: Int) : Aquarium2(height = height, width = diameter, length = diameter) {
    override var volume: Int
        // ellipse area = π * r1 * r2
        get() = (width/2 * length/2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width/2 * length/2)).toInt()
        }

    override var water = volume * 0.8

    override val shape = "cylinder"
}
