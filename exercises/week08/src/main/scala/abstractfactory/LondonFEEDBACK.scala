package main.scala.abstractfactory

import abstractfactory.XMLParser

class LondonFEEDBACK extends XMLParser {

    override def parse : String = {
        "London Parsing feedback XML...\n" +
        "London Feedback XML Message"
    }
}
