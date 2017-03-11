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

class ByteCodeFactoryImpl extends ByteCodeFactory {

    def make(byte: Byte, args: Int*): ByteCode = {

       byte match {
           case 1 => {
               args.length match {
                   case 0 => throw new IllegalArgumentException("A integer value to push to the stack is required")
                   case 1 => Iconst(args.head)
               }
           }
           case 2 => new Iadd
           case 3 => new Isub
           case 4 => new Imul
           case 5 => new Idiv
           case 6 => new Irem
           case 7 => new Ineg
           case 8 => new Iinc
           case 9 => new Idec
           case 10 => new Idup
           case 11 => new Iswap
           case 12 => new Print
           case _ => throw new InvalidBytecodeException("Invalid byte code")
       }
    }
}