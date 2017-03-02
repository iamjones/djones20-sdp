package strategy

case class CapTextFormatter() extends TextFormatter {
    override def format(text: String) {
        println("[CapTextFormatter]: " + text.toUpperCase)
    }
}
