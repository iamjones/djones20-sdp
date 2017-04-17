package bc

/**
  * [[ByteCodeFactory]] defines a factory interface for creating
  * [[ByteCode]] objects. You will need to extend this to provide
  * your own implementation of a [[ByteCodeFactory]].
  */
trait ByteCodeFactory {
    /**
      * Returns a [[ByteCode]].
      *
      * This method creates a new [[ByteCode]] object given the `byte`
      * that corresponds to the bytecode (see [[ByteCodeValues]]. If
      * the bytecode requires arguments then an optional integer
      * argument is provided.
      *
      * This method should throw an [[InvalidBytecodeException]] if the
      * given bytecode value is unknown.
      *
      * @param byte the byte code of a bytecode
      * @param args an optional integer argument (depends on bytecode)
      * @return a new bytecode object
      */
    def make(byte: Byte, args: Int*): ByteCode
}

class ByteCodeFactoryImpl extends ByteCodeFactory with ByteCodeValues {

    def make(byte: Byte, args: Int*): ByteCode = {

        /**
          * Iconst requires an Int to be pushed to the stack. If one is not
          * supplied then an InvalidBytecodeException is thrown.
          */
        byte match {
            case 1 =>
                args match {
                    case Nil => throw new InvalidBytecodeException("Iconst byte code needs a value to be pushed to the stack")
                    case _ => Iconst(args.head)
                }
            case 2 => Iadd
            case 3 => Isub
            case 4 => Imul
            case 5 => Idiv
            case 6 => Irem
            case 7 => Ineg
            case 8 => Iinc
            case 9 => Idec
            case 10 => Idup
            case 11 => Iswap
            case 12 => Print
            case _ => throw new InvalidBytecodeException("Invalid byte code")
        }
    }
}