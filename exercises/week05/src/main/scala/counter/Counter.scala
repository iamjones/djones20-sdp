/**
  * Created by davidjones on 09/02/2017.
  */
case class Counter(count: Int) {

    def inc(): Counter = {
        Counter(count + 1)
    }

    def dec(): Counter = {
        Counter(count - 1)
    }
}

object CounterRun {

    def main(args: Array[String]): Unit = {

        val start = 10

        val c: Counter = Counter(start)

        println(c.inc().dec().inc().inc().count)
    }
}