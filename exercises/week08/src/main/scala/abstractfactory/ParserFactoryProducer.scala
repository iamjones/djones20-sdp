package abstractfactory

import main.scala.abstractfactory.{LondonFactory, NYCFactory}

object ParserFactoryProducer {

    def getFactory(s: String) : AbstractParserFactory = {

        s match {
            case "NYCFactory" => new NYCFactory
            case "LondonFactory" => new LondonFactory
            case _ => throw new IllegalArgumentException("No parser with the name: " + s)
        }
    }
}