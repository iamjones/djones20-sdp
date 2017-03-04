package composite

import java.util
import java.util.List

abstract class HtmlTag(tagName: String) {

    var tagBodyContent : String = _
    var children : List[HtmlTag] = new util.ArrayList[HtmlTag]()

    def getTagName: String = tagName

    def setStartTag(tag: String)

    def setEndTag(tag: String)

    def setTagBody(tagBody: String) {
        tagBodyContent = tagBody
    }

    def addChildTag(htmlTag: HtmlTag) {
        children.add(htmlTag)
    }

    def removeChildTag(htmlTag: HtmlTag) {
        children.remove(htmlTag)
    }

    def getChildren: List[HtmlTag] = {
        children
    }

    def generateHtml
}