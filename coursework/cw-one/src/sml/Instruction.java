package sml;

/**
 * An abstract class that should be used for all instructions.
 */
public abstract class Instruction {

    protected String label;
    protected String opcode;

    /**
     * Constructor: an instruction with label l and opcode op.
     * (op must be an operation of the language)
     *
     * @param l String
     * @param op String
     */
    public Instruction(String l, String op) {
        this.label = l;
        this.opcode = op;
    }

    /**
     * The representation "label: opcode" of this Instruction.
     *
     * @return String
     */
    @Override
    public String toString() {
        return label + ": " + opcode;
    }

    /**
     * Execute this instruction on machine m.
     *
     * @param m Machine
     */
    public abstract void execute(Machine m);
}
