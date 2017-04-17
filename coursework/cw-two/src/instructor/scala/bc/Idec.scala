package bc

import vm.VirtualMachine

/**
  * An implementation of the Idec byte code.
  * The idec instruction pops one value from the virtual machine stack, decrements it by one and
  * pushes the result.
  * Remember to use the virtual machine instance returned from the pop calls.
  */
case object Idec extends ByteCode {

    override val code: Byte = bytecode("idec")

    override def execute(vm: VirtualMachine): VirtualMachine = {

        val value : (Int, VirtualMachine) = vm.pop()

        value._2.push(value._1 - 1)
    }
}