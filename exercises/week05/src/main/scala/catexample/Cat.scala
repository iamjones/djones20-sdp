package catexample

// Polymorphic
//sealed trait Feline {
//    def dinner: Food
//}
//
//final case class Cat() extends Feline {
//    def dinner = Mice()
//}
//
//final case class Lion() extends Feline {
//    def dinner = Antelope()
//}
//
//final case class Panther() extends Feline {
//    def dinner = Licorice()
//}
//
//final case cass Tiger() extends Feline {
//    def dinner = TigerFood()
//}

// Pattern matching
sealed trait Feline {
    def dinner : Food = this match {
        case Lion() => Antelope()
        case Tiger() => TigerFood()
        case Panther() => Licorice()
        case Cat() => Mice()
    }
}

final case class Cat() extends Feline
final case class Lion() extends Feline
final case class Panther() extends Feline
final case class Tiger() extends Feline