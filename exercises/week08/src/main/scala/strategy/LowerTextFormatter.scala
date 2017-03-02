package strategy

case class LowerTextFormatter() extends TextFormatter {
    override def format(text: String) {
        println("[LowerTextFormatter]: " + text.toLowerCase)
    }
}
