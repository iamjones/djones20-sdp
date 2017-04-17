package vm

import bc.ByteCode

class VirtualMachineImpl extends VirtualMachine {

    var vm : Vector[Int] = Vector[Int]()

    override def execute(bc: Vector[ByteCode]): VirtualMachine = {
        val vm = new VirtualMachineImpl
        bc.foreach(b => b.execute(vm))
        vm
    }

    override def executeOne(bc: Vector[ByteCode]): (Vector[ByteCode], VirtualMachine) = {
        bc.head.execute(this)
        (bc.tail, this)
    }

    override def push(value: Int): VirtualMachine = {
        vm = value +: vm
        this
    }

    override def pop(): (Int, VirtualMachine) = {

        if (vm.isEmpty) {
            throw new MachineUnderflowException("Stack is empty")
        }

        val i = vm.head
        this.vm = vm.tail

        (i, this)
    }

    override def state: Vector[Int] = {
        vm
    }
}
