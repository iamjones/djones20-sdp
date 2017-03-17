package sml;

/**
 * Multiplies the value in one register with a value in another register.
 * The computed value is stored in the appointed register.
 */
public class MulInstruction extends Instruction {

    private int result;
    private int op1;
    private int op2;

    /**
     * @param label String
     * @param op String
     */
    public MulInstruction(String label, String op) {
        super(label, op);
    }

    /**
     * @param label String
     * @param result int
     * @param op1 int
     * @param op2 int
     */
    public MulInstruction(String label, int result, int op1, int op2) {
        this(label, "mul");
        this.result = result;
        this.op1 = op1;
        this.op2 = op2;
    }

    /**
     * Multiplies the value in the first register with the value in the second
     * register. The result is stored in the declared register.
     *
     * @param m Machine
     */
    @Override
    public void execute(Machine m) {
        int value1 = m.getRegisters().getRegister(op1);
        int value2 = m.getRegisters().getRegister(op2);

        m.getRegisters().setRegister(result, value1 * value2);
    }

    /**
     * Returns a string in the form of:
     * $label: $opcode $op1 * $op2 to $result
     *
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + " " + op1 + " * " + op2 + " to " + result;
    }
}
