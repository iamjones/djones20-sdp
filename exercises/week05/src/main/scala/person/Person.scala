package person

class Person(f: String, s: String) {

    def firstname : String = f
    def surname : String   = s

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
        println(p.firstname)
        println(p.surname)

        val person = Person("Dave Jones")
        println(person.firstname)
        println(person.surname)
    }
}


