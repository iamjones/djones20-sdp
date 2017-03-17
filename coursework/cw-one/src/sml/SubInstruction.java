package sml;

/**
 * Subtracts the value in one register with a value in another register.
 * The computed value is stored in the appointed register.
 */
public class SubInstruction extends Instruction {

    private int result;
    private int op1;
    private int op2;

    /**
     * @param label String
     * @param op String
     */
    public SubInstruction(String label, String op) {
        super(label, op);
    }

    /**
     * @param label String
     * @param result int
     * @param op1 int
     * @param op2 int
     */
    public SubInstruction(String label, int result, int op1, int op2) {
        this(label, "sub");
        this.result = result;
        this.op1 = op1;
        this.op2 = op2;
    }

    /**
     * Gets the values of the registers that were passed into the constructor.
     * The values from the second register is subtracted from the value of the
     * first register and the computed value is stored in the result register.
     *
     * @param m Machine
     */
    @Override
    public void execute(Machine m) {
        int value1 = m.getRegisters().getRegister(op1);
        int value2 = m.getRegisters().getRegister(op2);
        m.getRegisters().setRegister(result, value1 - value2);
    }

    /**
     * Returns a string in the form of:
     * $label: $opcode $op1 - $op2 to $result
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + " " + op1 + " - " + op2 + " to " + result;
    }
}
