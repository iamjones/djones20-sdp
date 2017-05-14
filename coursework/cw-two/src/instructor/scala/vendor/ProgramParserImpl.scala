package vendor

class ProgramParserImpl extends ProgramParser {

    override type InstructionList = Vector[Instruction]

    override def parse(file: String): InstructionList = {

        val lines        = scala.io.Source.fromFile(file).getLines()
        var instructions = Vector[Instruction]()

        lines.foreach(line => {
            instructions ++= parseString(line)
        })

        instructions
    }

    override def parseString(string: String): InstructionList = {

        val items : Array[String] = string.split("\n")
        var instructions = Vector[Instruction]()

        items.foreach(item => {

            if (item.contains(" ")) {
                val split : Array[String] = item.split(" ")
                val args : Vector[Int] = Vector[Int](split.last.toInt)
                instructions = instructions :+ new Instruction(split.head, args)
            } else {
                instructions = instructions :+ new Instruction(item, Vector[Int]())
            }
        })

        instructions
    }
}
