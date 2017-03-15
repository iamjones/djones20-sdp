package vm
import bc.ByteCode

class VirtualMachineImpl extends VirtualMachine {

    override def execute(bc: Vector[ByteCode]): VirtualMachine = ???

    override def executeOne(bc: Vector[ByteCode]): (Vector[ByteCode], VirtualMachine) = ???

    override def push(value: Int): VirtualMachine = ???

    override def pop(): (Int, VirtualMachine) = ???

    override def state: Vector[Int] = ???
}
