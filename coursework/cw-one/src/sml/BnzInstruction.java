package sml;

/**
 * If the contents of the register is not zero then make the statement that is passed
 * with the instruction the next one to execute.
 */
public class BnzInstruction extends Instruction {

    private int register;
    private String op1;

    public BnzInstruction(String label, String op) {
        super(label, op);
    }

    public BnzInstruction(String label, int register, String op1) {
        this(label, "bnz");
        this.register = register;
        this.op1 = op1;
    }

    @Override
    public void execute(Machine m) {
        int value1 = m.getRegisters().getRegister(this.register);

        if (value1 != 0) {
            int count = m.getLabels().indexOf(this.op1);
            m.setPc(count);
        }
    }

    @Override
    public String toString() {
        return super.toString() + " replay instruction " + this.op1 + " if register " + this.register + " is not zero";
    }
}
