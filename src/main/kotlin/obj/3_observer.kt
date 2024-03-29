package obj

fun main() {
    EventPrinter().start()
}

interface EventListener {
    fun onEvent(count: Int)
}

class Counter(var listener: EventListener) {
    fun count() {
        for(i in 1..10) {
            if (i % 5 ==0) listener.onEvent(i)
        }
    }
}

class EventPrinter: EventListener {
    override fun onEvent(count: Int) {
        print("${count}-")
    }

    fun start() {
        // Counter 기명 객체 사용
//        val counter = Counter(this)

        // 익명객체
        val counter = Counter(object: EventListener {
            override fun onEvent(count: Int) {
                print("${count}-")
            }
        })

        counter.count()

    }
}
