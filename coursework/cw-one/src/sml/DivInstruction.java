package sml;

/**
 * Divides the value in one register with a value in another register.
 * The computed value is stored in the appointed register.
 */
public class DivInstruction extends Instruction {

    private int result;
    private int op1;
    private int op2;

    /**
     * @param label String
     * @param op String
     */
    public DivInstruction(String label, String op) {
        super(label, op);
    }

    /**
     * @param label String
     * @param result int
     * @param op1 int
     * @param op2 int
     */
    public DivInstruction(String label, int result, int op1, int op2) {
        this(label, "div");
        this.result = result;
        this.op1 = op1;
        this.op2 = op2;
    }

    /**
     * Divides the value in first register by the value in the second register.
     *
     * @param m Machine
     * @throws IllegalArgumentException If the second register contains zero
     */
    @Override
    public void execute(Machine m) throws IllegalArgumentException {
        int value1 = m.getRegisters().getRegister(op1);
        int value2 = m.getRegisters().getRegister(op2);

        if (value2 == 0) {
            throw new IllegalArgumentException("The second register contains a zero. You cannot divide by zero.");
        }

        m.getRegisters().setRegister(result, value1 / value2);
    }

    /**
     * Returns a string in the form of:
     * $label: $opcode $op1 / $op2 to $result
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + " " + op1 + " / " + op2 + " to " + result;
    }
}
