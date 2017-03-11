package bc

import vm.VirtualMachine

/**
  * An exception representing an invalid bytecode. This can be used
  * in any circumstance where a bytecode might be invalid.
  *
  * @param msg the exception message
  */
class InvalidBytecodeException(msg: String) extends Exception(msg)

/**
  * [[ByteCodeValues]] is a trait containing a couple of useful definitions.
  * You should extend this trait in other classes that might find the
  * definitions below useful.
  */
trait ByteCodeValues {
    /**
      * A vector of the allowable bytecode names.
      * Not particularly flexible but that isn't the point of this assessment.
      */
    val names = Vector("iconst", "iadd", "isub", "imul", "idiv", "irem",
        "ineg", "iinc", "idec", "idup", "iswap", "print")

    /**
      * A map from bytecode names to a unique byte that represents them.
      */
    val bytecode = names.zip(1.to(names.length).map(_.toByte)).toMap
}

/**
  * [[ByteCode]] is a trait that represents a bytecode operation that can
  * be executed by a virtual machine. We use the *command* pattern here
  * to execute the bytecode operation. A bytecode must have a code (a
  * unique byte representing the bytecode - see [[ByteCodeValues.bytecode]])
  * and a method that executes the bytecode operation on the given
  * virtual machine.
  *
  * This trait extends the [[ByteCodeValues]] trait to give an
  * implementation access to the definitions provided by the
  * that trait.
  */
trait ByteCode extends ByteCodeValues {
    /**
      * A unique byte value representing the bytecode. An implementation
      * will set this to the bytecode corresponding to the name of the
      * bytecode in [[ByteCodeValues]]
      */
    val code: Byte

    /**
      * Returns a new [[VirtualMachine]] after executing this bytecode operation.
      *
      * @param vm the initial virtual machine
      * @return a new virtual machine
      */
    def execute(vm: VirtualMachine): VirtualMachine
}

// 1
class Iconst extends ByteCode {

    override val code: Byte = bytecode("iconst")

    override def execute(vm: VirtualMachine): VirtualMachine = {

        vm.push(code)
    }
}

// 2
class Iadd extends ByteCode {

    override val code: Byte = bytecode("iadd")

    override def execute(vm: VirtualMachine): VirtualMachine = {

        vm.push(code)
    }
}

// 3
class Isub extends ByteCode {

    override val code: Byte = bytecode("isub")

    override def execute(vm: VirtualMachine): VirtualMachine = {

        vm.push(code)
    }
}

// 4
class Imul extends ByteCode {

    override val code: Byte = bytecode("imul")

    override def execute(vm: VirtualMachine): VirtualMachine = {

        vm.push(code)
    }
}

// 5
class Idiv extends ByteCode {

    override val code: Byte = bytecode("idiv")

    override def execute(vm: VirtualMachine): VirtualMachine = {

        vm.push(code)
    }
}

// 6
class Irem extends ByteCode {

    override val code: Byte = bytecode("irem")

    override def execute(vm: VirtualMachine): VirtualMachine = {

        vm.push(code)
    }
}

// 7
class Ineg extends ByteCode {

    override val code: Byte = bytecode("ineg")

    override def execute(vm: VirtualMachine): VirtualMachine = {

        vm.push(code)
    }
}

// 8
class Iinc extends ByteCode {

    override val code: Byte = bytecode("iinc")

    override def execute(vm: VirtualMachine): VirtualMachine = {

        vm.push(code)
    }
}

// 9
class Idec extends ByteCode {

    override val code: Byte = bytecode("idec")

    override def execute(vm: VirtualMachine): VirtualMachine = {

        vm.push(code)
    }
}

// 10
class Idup extends ByteCode {

    override val code: Byte = bytecode("idup")

    override def execute(vm: VirtualMachine): VirtualMachine = {

        vm.push(code)
    }
}

// 11
class Iswap extends ByteCode {

    override val code: Byte = bytecode("iswap")

    override def execute(vm: VirtualMachine): VirtualMachine = {

        vm.push(code)
    }
}

// 12
class Print extends ByteCode {

    override val code: Byte = bytecode("print")

    override def execute(vm: VirtualMachine): VirtualMachine = {

        vm.push(code)
    }
}