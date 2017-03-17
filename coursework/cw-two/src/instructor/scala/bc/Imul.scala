package bc

import vm.VirtualMachine

/**
  * An implementation of the Imul byte code.
  * The imul instruction pops the top two values from the virtual machine stack, multiplies them and
  * pushes the result.
  * Remember to use the virtual machine instance returned from the pop calls.
  */
case object Imul extends ByteCode {

    override val code: Byte = bytecode("imul")

    override def execute(vm: VirtualMachine): VirtualMachine = {

        val value1 : (Int, VirtualMachine) = vm.pop()
        val value2 : (Int, VirtualMachine) = value1._2.pop()

        value2._2.push(value1._1 * value2._1)
    }
}