package film

class Director(
  val firstName : String,
  val lastName : String,
  val yearOfBirth : Int
) {
    // Question 3.a
    def name() : String = {
        s"$firstName $lastName"
    }
}

object Director {

    // Question 3.b
    def apply(firstName : String, lastName : String, yearOfBirth : Int): Director = {
        new Director(firstName, lastName, yearOfBirth)
    }

    // Question 3.b
    def older(d1 : Director, d2 : Director): Director = {
        if (d1.yearOfBirth > d2.yearOfBirth) {
            d2
        }

        d1
    }
}
