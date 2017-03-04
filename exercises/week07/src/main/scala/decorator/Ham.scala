package decorator

class Ham(val pizza: Pizza) extends Pizza {

    def getDesc: String = {
        pizza.getDesc + ", Ham (18.12)"
    }

    def getPrice: Double = {
        pizza.getPrice + 18.12
    }
}
