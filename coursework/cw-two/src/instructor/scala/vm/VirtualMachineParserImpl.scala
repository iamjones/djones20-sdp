package vm
import bc._

class VirtualMachineParserImpl extends VirtualMachineParser with ByteCodeValues {

    def byteCodeFactory : ByteCodeFactory = new ByteCodeFactoryImpl

    override def parse(file: String): Vector[ByteCode] = {

        val lines     = scala.io.Source.fromFile(file).getLines()
        var bytecodes = Vector[ByteCode]()

        lines.foreach(l => bytecodes ++= makeByteCode(l))

        bytecodes
    }

    override def parseString(str: String): Vector[ByteCode] = {

        val args : Array[String] = str.split("\n")
        var bytecodes = Vector[ByteCode]()

        args.foreach(a => bytecodes ++= makeByteCode(a))

        bytecodes
    }

    /**
      * Takes a string and creates a byte code. If the byte code is
      * an iconst we need to make sure an integer is also passed.
      *
      * @param str String
      * @return Vector[ByteCode]
      */
    def makeByteCode(str: String): Vector[ByteCode] = {

        var bytecodes = Vector[ByteCode]()
        val split : Array[String] = str.split(" ")
        val codeName = split.head.toString

        if (!names.contains(codeName)) {
            throw new InvalidBytecodeException(s"$codeName is not a valid byte code")
        }

        if (bytecode(codeName) == bytecode("iconst")) {
            bytecodes = bytecodes :+ byteCodeFactory.make(bytecode(codeName), split.last.toInt)
        } else {
            bytecodes = bytecodes :+ byteCodeFactory.make(bytecode(codeName))
        }

        bytecodes
    }
}
