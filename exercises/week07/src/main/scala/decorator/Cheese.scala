package decorator

class Cheese(val pizza: Pizza) extends Pizza {

    def getDesc: String = {
        pizza.getDesc + ", Cheese (20.72)"
    }

    def getPrice: Double = {
        pizza.getPrice + 20.72
    }
}
