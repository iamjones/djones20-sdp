package bc

import vm.VirtualMachine

/**
  * An implementation of the Ineg byte code.
  * The ineg instruction pops one value from the virtual machine stack, negates it and
  * pushes the result.
  * Remember to use the virtual machine instance returned from the pop calls.
  */
case object Ineg extends ByteCode {

    override val code: Byte = bytecode("ineg")

    override def execute(vm: VirtualMachine): VirtualMachine = {

        val value : (Int, VirtualMachine) = vm.pop()

        value._2.push(-value._1)
    }
}