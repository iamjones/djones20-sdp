package film

case class Director(
  firstName : String,
  lastName : String,
  yearOfBirth : Int
) {
    // Question 3.a
    def name() : String = {
        s"$firstName $lastName"
    }
}

object Director {

    // Question 3.b
    def older(d1 : Director, d2 : Director): Director = {
        if (d1.yearOfBirth > d2.yearOfBirth) {
            d2
        }

        d1
    }
}
