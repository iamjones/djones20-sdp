package bc

import vm.VirtualMachine

/**
  * An implementation of the Iconst byte code.
  * Take an integer and pushes to the stack of the virtual machine instance.
  *
  * @param num
  */
case class Iconst(num: Int*) extends ByteCode {

    override val code: Byte = bytecode("iconst")

    override def execute(vm: VirtualMachine): VirtualMachine = {
        vm.push(num.head)
    }
}
