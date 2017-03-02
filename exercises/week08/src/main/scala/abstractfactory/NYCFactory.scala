package main.scala.abstractfactory

import abstractfactory.{AbstractParserFactory, XMLParser}

class NYCFactory extends AbstractParserFactory {
    override def getParserInstance(parserType: String): XMLParser = {

        parserType match {
            case "NYCORDER" => new NYCORDER
            case _ => throw new IllegalArgumentException("No NYC factory named: " + parserType)
        }
    }
}
