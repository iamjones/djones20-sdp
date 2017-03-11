package bc

import vm.VirtualMachine

/**
  * An implementation of the print byte code.
  * The print instruction pops one value from the virtual machine stack
  * and prints the value to the console.
  * Remember to use the virtual machine instance returned from the pop calls.
  */
class Print extends ByteCode {

    override val code: Byte = bytecode("print")

    override def execute(vm: VirtualMachine): VirtualMachine = {

        val value : (Int, VirtualMachine) = vm.pop()

        println(value._1)

        value._2
    }
}