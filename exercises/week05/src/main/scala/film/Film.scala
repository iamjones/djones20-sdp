package film

class Film(
  val name : String,
  val yearOfRelease : Int,
  val imdbRating : Double,
  val director: Director
) {

    // Question 3.a
    def directorsAge() : Int = {
        director.yearOfBirth - yearOfRelease
    }

    // Question 3.a
    def isDirectedBy(d: Director) : Boolean = {
        director.equals(d)
    }

    // Question 3.a
    def copy(name : String, yearOfRelease : Int, imdbRating : Double, director: Director) : Film = {
        Film(name, yearOfRelease, imdbRating, director)
    }
}

object Film {

    // Question 3.b
    def apply(name : String, yearOfRelease : Int, imdbRating : Double, director: Director) : Film = {
        Film(name, yearOfRelease, imdbRating, director)
    }

    // Question 3.b
    def highestRating(f1 : Film, f2 : Film) : Film = {
        if (f1.imdbRating > f2.imdbRating) {
            f1
        }

        f2
    }

    // Question 3.b
    def oldestDirectorAtTheTime(f1 : Film, f2 : Film) : Director = {
        if (f1.director.yearOfBirth > f2.director.yearOfBirth) {
            f1.director
        }

        f2.director
    }
}
