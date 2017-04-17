package bc

/**
  * [[ByteCodeParser]] parses byte code values.
  * You will need to extend this to provide your own implementation
  * of a [[ByteCodeParser]]. It extends [[ByteCodeValues]] for
  * convenient access to its definitions.
  */
trait ByteCodeParser extends ByteCodeValues {
    /**
      * Parses a vector of `Byte` into a vector of `ByteCode`.
      *
      * You should use [[ByteCodeValues.bytecode]] to help translate
      * the individual `Byte`s into a correponding [[ByteCode]].
      *
      * @param bc a vector of bytes representing bytecodes
      * @return a vector of `ByteCode` objects
      */
    def parse(bc: Vector[Byte]): Vector[ByteCode]
}

class ByteCodeParserImpl extends ByteCodeParser {

    val byteCodeFactory : ByteCodeFactory = new ByteCodeFactoryImpl

    override def parse(bc: Vector[Byte]): Vector[ByteCode] = {

        var codes = Vector[ByteCode]()
        val l : Int = bc.length
        var c : Int = 0

        while (c < l) {

            if (bc(c) == bytecode("iconst")) {
                codes = codes :+ byteCodeFactory.make(bc(c), bc(c + 1))
                c += 1
            } else {
                codes = codes :+ byteCodeFactory.make(bc(c))
            }

            c += 1
        }

        codes
    }
}
