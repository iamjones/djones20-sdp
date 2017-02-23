package main.scala.factory

class ConcreteCreator extends Creator {

    override def factoryMethod : Product = {
        new ConcreteProduct()
    }
}
