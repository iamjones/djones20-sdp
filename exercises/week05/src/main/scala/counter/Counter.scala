class Counter(c: Int) {

    def count : Int = c

    def inc(c : Int = 0): Counter = {
        c match {
            case 0 => new Counter(count + 1)
            case _ => new Counter(count + c)
        }
    }

    def dec(c : Int = 0): Counter = {
        c match {
            case 0 => new Counter(count - 1)
            case _ => new Counter(count - c)
        }
    }
}

object CounterRun {

    def main(args: Array[String]): Unit = {

        val start = 10

        val c: Counter = new Counter(start)

        println(c.inc().dec().inc().inc().count)
    }
}