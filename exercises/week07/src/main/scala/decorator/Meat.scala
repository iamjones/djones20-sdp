package decorator

class Meat(val pizza: Pizza) extends Pizza {

    def getDesc: String = {
        pizza.getDesc + ", Meat (14.25)"
    }

    def getPrice: Double = {
        pizza.getPrice + 14.25
    }
}
