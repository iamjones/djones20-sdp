package main.scala.abstractfactory

import abstractfactory.XMLParser

class NYCORDER extends XMLParser {

    override def parse : String = {
        "NYC Parsing order XML...\n" +
        "NYC Order XML Message"
    }
}
