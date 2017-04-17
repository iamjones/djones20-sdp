package bc

import vm.VirtualMachine

/**
  * An implementation of the Iswap byte code.
  * The iswap instruction pops the top two values from the virtual machine stack,
  * and pushes them back in the opposite order.
  * Remember to use the virtual machine instance returned from the pop calls.
  */
case object Iswap extends ByteCode {

    override val code: Byte = bytecode("iswap")

    override def execute(vm: VirtualMachine): VirtualMachine = {

        val value1 : (Int, VirtualMachine) = vm.pop()
        val value2 : (Int, VirtualMachine) = value1._2.pop()

        val virtualMachine : VirtualMachine = value1._2.push(value1._1)
        virtualMachine.push(value2._1)
    }
}