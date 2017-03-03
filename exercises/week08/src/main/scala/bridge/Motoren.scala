package bridge

case class Motoren(product: Product, s: String) extends Car(product, s) {

    override def assemble {
        println("Assembling" + product.productName + " for " + s)
    }

    override def produceProduct {
        product.produce
    }

    override def printDetails {
        println("Car: " + s + ", Product: " + product.productName)
    }
}
