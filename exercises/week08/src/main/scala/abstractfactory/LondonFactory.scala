package main.scala.abstractfactory

import abstractfactory.{AbstractParserFactory, XMLParser}

class LondonFactory extends AbstractParserFactory {

    override def getParserInstance(parserType: String): XMLParser = {

        parserType match {
            case "LondonFEEDBACK" => new LondonFEEDBACK
            case _ => throw new IllegalArgumentException("No london factory named: " + parserType)
        }
    }
}
