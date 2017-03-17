package sml;

/**
 * If the contents of the register is not zero then make the statement that is passed
 * with the instruction the next one to execute.
 */
public class BnzInstruction extends Instruction {

    private int register;
    private String op1;

    /**
     * @param label String
     * @param op String
     */
    public BnzInstruction(String label, String op) {
        super(label, op);
    }

    /**
     * @param label String
     * @param register int
     * @param op1 String
     */
    public BnzInstruction(String label, int register, String op1) {
        this(label, "bnz");
        this.register = register;
        this.op1 = op1;
    }

    /**
     * If the value in the given register is not zero then we need to make
     * the given operation the next one to execute.
     *
     * @param m Machine
     */
    @Override
    public void execute(Machine m) {
        int value1 = m.getRegisters().getRegister(this.register);

        if (value1 != 0) {
            int count = m.getLabels().indexOf(this.op1);
            m.setPc(count);
        }
    }

    /**
     * Returns a string in the form of:
     * $label: $opcode replay instruction $op1 if register $register is not zero
     *
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + " replay instruction " + this.op1 + " if register " + this.register + " is not zero";
    }
}
