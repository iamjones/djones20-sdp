package bc

import vm.VirtualMachine

/**
  * An implementation of the Idup byte code.
  * The idup instruction pops one value from the virtual machine stack and
  * pushes the value twice.
  * Remember to use the virtual machine instance returned from the pop calls.
  */
case object Idup extends ByteCode {

    override val code: Byte = bytecode("idup")

    override def execute(vm: VirtualMachine): VirtualMachine = {

        val value : (Int, VirtualMachine) = vm.pop()

        val virtualMachine : VirtualMachine = value._2.push(value._1)
        virtualMachine.push(value._1)
    }
}