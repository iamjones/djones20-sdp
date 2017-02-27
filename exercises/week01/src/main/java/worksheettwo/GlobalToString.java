package main.java.worksheettwo;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Method to take a class name and return a map of all the parameter names
 * and values.
 */
public class GlobalToString {

    public static void main(String[] args) {

        System.out.println("Enter the name of a class: ");

        Scanner in        = new Scanner(System.in);
        String className  = in.next();

        System.out.println(GlobalToString.get(className));
    }

    public static Map get(String className) {

        try {
            Class enteredClass = Class.forName(className);

            Field[] fields = enteredClass.getDeclaredFields();

            Map toString = new HashMap();

            for (Field f : fields) {



                toString.put(f.getName(), f.get(enteredClass));
            }

            return toString;

        } catch (ClassNotFoundException | IllegalAccessException e) {
            return null;
        }
    }

}
