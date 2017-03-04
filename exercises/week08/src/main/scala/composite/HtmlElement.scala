package composite

case class HtmlElement(s: String) extends HtmlTag(s) {

    var startTag : String = _
    var endTag : String = _

    override def setStartTag(tag: String) {
        startTag = tag
    }

    override def setEndTag(tag: String) {
        endTag = tag
    }

    override def generateHtml {
        println(startTag + tagBodyContent + endTag)
    }
}
