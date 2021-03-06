package sml;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
public class Translator {

    private static final String PATH = "/Users/davidjones/Dropbox/github/sdp/coursework/cw-one/";
    // word + line is the part of the current line that's not yet processed
    // word has no whitespace
    // If word and line are not empty, line begins with whitespace
    private String line = "";
    private Labels labels; // The labels of the program being translated
    private ArrayList<Instruction> program; // The program to be created
    private String fileName; // source file of SML code

    public Translator(String fileName) {
        this.fileName = PATH + fileName;
    }

    // translate the small program in the file into lab (the labels) and
    // prog (the program)
    // return "no errors were detected"
    public boolean readAndTranslate(Labels lab, ArrayList<Instruction> prog) {

        try (Scanner sc = new Scanner(new File(fileName))) {
            // Scanner attached to the file chosen by the user
            labels = lab;
            labels.reset();
            program = prog;
            program.clear();

            try {
                line = sc.nextLine();
            } catch (NoSuchElementException ioE) {
                return false;
            }

            // Each iteration processes line and reads the next line into line
            while (line != null) {
                // Store the label in label
                String label = scan();

                if (label.length() > 0) {
                    Instruction ins = getInstruction(label);
                    if (ins != null) {
                        labels.addLabel(label);
                        program.add(ins);
                    }
                }

                try {
                    line = sc.nextLine();
                } catch (NoSuchElementException ioE) {
                    return false;
                }
            }
        } catch (IOException ioE) {
            System.out.println("File: IO error " + ioE.getMessage());
            System.exit(-1);
            return false;
        }

        return true;
    }

    /**
     * Line should consist of an MML instruction, with its label already removed.
     * Translate line into an instruction with label label and return the instruction.
     *
     * @param label String
     * @return Instruction
     */
    public Instruction getInstruction(String label) {

        if (line.equals(""))
            return null;

        String ins = scan();
        String insCapitalised  = ins.substring(0, 1).toUpperCase() + ins.substring(1).toLowerCase();
        String className  = "sml." + insCapitalised + "Instruction";

        try {

            Constructor<?>[] constructors = Class.forName(className).getConstructors();
            Constructor constructor = null;
            int constructorParamCount = 0;

            // Find the constructor with the maximum number of params
            for (Constructor c : constructors) {

                if (c.getParameterCount() > constructorParamCount) {
                    constructor = c;
                    constructorParamCount = c.getParameterCount();
                }
            }

            if (constructor == null) {
                throw new NoSuchMethodException("The class '" + className + "' needs to have a constructor.");
            }

            // Map the required list of parameters to values in an array
            List<Object> arguments = new ArrayList<>();
            // We will always have a label
            arguments.add(label);

            AnnotatedType[] params = constructor.getAnnotatedParameterTypes();

            for (AnnotatedType p : params) {

                // Ignore the first argument as its always label
                if (p == params[0]) {
                    continue;
                }

                // If the parameter type is an int then we call scanInt and add the returned value to the list
                if (p.getType() == int.class) {
                    arguments.add(scanInt());
                }

                // If the parameter type is a String then we call scan and add the returned value to the list
                if (p.getType() == String.class) {
                    arguments.add(scan());
                }
            }

            return (Instruction) constructor.newInstance(arguments.toArray());

        } catch (ClassNotFoundException e) {
            System.out.println("The instruction '" + ins + "' does not exist.");
        } catch (IllegalAccessException | InstantiationException |
                InvocationTargetException | IllegalArgumentException | NullPointerException | NoSuchMethodException e) {
            System.out.println("A " + e.getClass() + " was thrown.");
            System.out.println(e.getMessage());
        }

        return null;
    }

    /**
     * Return the first word of line and remove it from line. If there is no
     * word, return ""
     *
     * @return String
     */
    private String scan() {
        line = line.trim();
        if (line.length() == 0)
            return "";

        int i = 0;
        while (i < line.length() && line.charAt(i) != ' ' && line.charAt(i) != '\t') {
            i = i + 1;
        }
        String word = line.substring(0, i);
        line = line.substring(i);
        return word;
    }

    /**
     * Return the first word of line as an integer. If there is any error, return the maximum int.
     *
     * @return int
     */
    private int scanInt() {
        String word = scan();
        if (word.length() == 0) {
            return Integer.MAX_VALUE;
        }

        try {
            return Integer.parseInt(word);
        } catch (NumberFormatException e) {
            return Integer.MAX_VALUE;
        }
    }
}
