package sml;

/**
 * Adds the values of two register and stores it in a register.
 */
public class AddInstruction extends Instruction {

    private int result;
    private int op1;
    private int op2;

    /**
     * @param label String
     * @param op String
     */
    public AddInstruction(String label, String op) {
        super(label, op);
    }

    /**
     * @param label String
     * @param result int
     * @param op1 int
     * @param op2 int
     */
    public AddInstruction(String label, int result, int op1, int op2) {
        this(label, "add");
        this.result = result;
        this.op1 = op1;
        this.op2 = op2;
    }

    /**
     * Takes a machine and gets the value of the two registers that were supplied
     * in the constructor. The values are added together and set in another register.
     *
     * @param m Machine
     */
    @Override
    public void execute(Machine m) {
        int value1 = m.getRegisters().getRegister(op1);
        int value2 = m.getRegisters().getRegister(op2);
        m.getRegisters().setRegister(result, value1 + value2);
    }

    /**
     * Returns a string in the form of:
     * $label: $opcode $op1 + $op2 to $result
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + " " + op1 + " + " + op2 + " to " + result;
    }
}
