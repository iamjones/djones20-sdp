package decorator

class Spinach(val pizza: Pizza) extends Pizza {

    def getDesc: String = {
        pizza.getDesc + ", Spinach (7.92)"
    }

    def getPrice: Double = {
        pizza.getPrice + 7.92
    }
}
