package sml;

public class LinInstruction extends Instruction {
    private int register;
    private int value;

    /**
     * @param label String
     * @param opcode String
     */
    public LinInstruction(String label, String opcode) {
        super(label, opcode);
    }

    /**
     * @param label String
     * @param register int
     * @param value int
     */
    public LinInstruction(String label, int register, int value) {
        super(label, "lin");
        this.register = register;
        this.value = value;

    }

    /**
     * Sets the a value to the a register.
     *
     * @param m Machine
     */
    @Override
    public void execute(Machine m) {
        m.getRegisters().setRegister(register, value);
    }

    /**
     * Returns a string in the form of:
     * $label: $opcode register $register value is $value
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + " register " + register + " value is " + value;
    }
}
