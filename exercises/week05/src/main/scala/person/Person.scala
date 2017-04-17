package person

case class Person(f: String, s: String) {

}

object Person {
    def apply(name : String) : Person = {
        val parts = name.split(" ")

        parts.length match {
            case 2 => new Person(parts(0), parts(1))
            case _ => throw new IllegalArgumentException
        }
    }
}

object PersonTester {

    def main(args: Array[String]): Unit = {

        // Question 2.a
        val p = new Person("David", "Jones")
        println(p.f)
        println(p.s)

        val person = Person("Dave Jones")
        println(person.f)
        println(person.s)
    }
}


