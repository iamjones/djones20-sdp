package decorator

class RomaTomatoes(val pizza: Pizza) extends Pizza {

    def getDesc: String = {
        pizza.getDesc + ", Roma Tomatoes (5.20)"
    }

    def getPrice: Double = {
        pizza.getPrice + 5.20
    }
}
