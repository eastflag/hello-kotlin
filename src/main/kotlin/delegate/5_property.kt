package delegate

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// 속성 위임

fun main() {
    val samsungTv = SmartTvDevice("samsung", "tv")
    samsungTv.speakerVolume
    samsungTv.speakerVolume = 50
    samsungTv.speakerVolume
    samsungTv.speakerVolume = 500  // 범위를 벗어나서 적용안됨
    samsungTv.speakerVolume
}

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        println("regulator get $fieldData")
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
        println("regulator set $fieldData")
    }
}



class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

}

open class SmartDevice(val name: String, val category: String) {
    open val deviceType: String = ""
    var deviceStatus = "online"

    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }

    fun turnOn() {
        println("Smart device is turned on.")
    }

    fun turnOff() {
        println("Smart device is turned off.")
    }
}
