import counter.Adder

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

     def adjust(adder : Adder) : CaseCounter = {
         CaseCounter(adder.add(c))
     }
}

object CaseCounterRun {

    def main(args: Array[String]): Unit = {

        val start = 10

        // Question 1.a + 1.b
        val c: CaseCounter = CaseCounter(start)
        println(c.inc().dec().inc().inc().count)

        // Question 1.c
        val copied : CaseCounter = c.copy(c=0)
        println(copied.inc().dec().inc().inc().count)

        // Question 1.d
        val x = CaseCounter(start)
        val numToAdd = 100
        val ad = new Adder(numToAdd)

        println(x.adjust(ad).count)
    }
}