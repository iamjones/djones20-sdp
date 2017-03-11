package bc

import vm.VirtualMachine

/**
  * An implementation of the Iinc byte code.
  * The iinc instruction pops one value from the virtual machine stack, increments it by one and
  * pushes the result.
  * Remember to use the virtual machine instance returned from the pop calls.
  */
class Iinc extends ByteCode {

    override val code: Byte = bytecode("iinc")

    override def execute(vm: VirtualMachine): VirtualMachine = {

        val value : (Int, VirtualMachine) = vm.pop()

        value._2.push(value._1 + 1)
    }
}