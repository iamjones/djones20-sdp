package sml;

/**
 * Prints out the value of the given register to the console.
 */
public class OutInstruction extends Instruction {

    private int register;

    public OutInstruction(String label, String op) {
        super(label, op);
    }

    public OutInstruction(String label, int register) {
        this(label, "out");
        this.register = register;
    }

    @Override
    public void execute(Machine m) {
        int value1 = m.getRegisters().getRegister(this.register);

        System.out.println("Register " + this.register + " = " + value1);
    }

    @Override
    public String toString() {
        return super.toString() + " print value of " + this.register;
    }
}
