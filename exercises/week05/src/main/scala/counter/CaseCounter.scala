 case class CaseCounter(c: Int = 0) {

    def count : Int = c

    def inc(c : Int = 0): CaseCounter = {
        c match {
            case 0 => CaseCounter(count + 1)
            case _ => CaseCounter(count + c)
        }
    }

    def dec(c : Int = 0): CaseCounter = {
        c match {
            case 0 => CaseCounter(count - 1)
            case _ => CaseCounter(count - c)
        }
    }
}

object CaseCounterRun {

    def main(args: Array[String]): Unit = {

        val start = 10

        val c: CaseCounter = CaseCounter(start)

        println(c.inc().dec().inc().inc().count)
    }
}