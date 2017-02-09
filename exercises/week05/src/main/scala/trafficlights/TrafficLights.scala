// Polymorphism
//sealed trait TrafficLights {
//    def next : TrafficLights
//}
//
//// Traffic light will only have the following subclass
//// final will not allow sub types of the same name
//// now the compiler knows what the options are
//final case object Red extends TrafficLights {
//    def next = Green
//}
//
//final case object Amber extends TrafficLights {
//    def next = Red
//}
//
//final case object Green extends TrafficLights {
//    def next = Amber
//}

// Pattern matching
sealed trait TrafficLights {
    def next : TrafficLights =
        this match {
            case Red => Green
            case Green => Amber
            case Amber => Red
        }
}

final case object Red extends TrafficLights
final case object Amber extends TrafficLights
final case object Green extends TrafficLights