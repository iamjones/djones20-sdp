package sml;

/**
 * Prints out the value of the given register to the console.
 */
public class OutInstruction extends Instruction {

    private int register;

    /**
     * @param label String
     * @param register int
     */
    public OutInstruction(String label, int register) {
        super(label, "out");
        this.register = register;
    }

    /**
     * Print the value of a register.
     *
     * @param m Machine
     */
    @Override
    public void execute(Machine m) {
        int value1 = m.getRegisters().getRegister(this.register);

        System.out.println("Register " + this.register + " = " + value1);
    }

    /**
     * Returns a string in the form of:
     * $label: $opcode print value of $register
     *
     * @return String
     */
    @Override
    public String toString() {
        return super.toString() + " print value of " + this.register;
    }
}
