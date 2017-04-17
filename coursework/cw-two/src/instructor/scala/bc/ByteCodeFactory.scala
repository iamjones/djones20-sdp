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
          *
          * Having to do an if statement inside each case block because we are
          * unable to directly call the bytecode function.
          */
        byte match {
            case `byte` if bytecode("iconst") == byte =>
                args match {
                    case Nil => throw new InvalidBytecodeException("Iconst byte code needs a value to be pushed to the stack")
                    case _ => Iconst(args.head)
                }
            case `byte` if bytecode("iadd") == byte => Iadd
            case `byte` if bytecode("isub") == byte => Isub
            case `byte` if bytecode("imul") == byte => Imul
            case `byte` if bytecode("idiv") == byte => Idiv
            case `byte` if bytecode("irem") == byte => Irem
            case `byte` if bytecode("ineg") == byte => Ineg
            case `byte` if bytecode("iinc") == byte => Iinc
            case `byte` if bytecode("idec") == byte => Idec
            case `byte` if bytecode("idup") == byte => Idup
            case `byte` if bytecode("iswap") == byte => Iswap
            case `byte` if bytecode("print") == byte => Print
            case _ => throw new InvalidBytecodeException("Invalid byte code")
        }
    }
}