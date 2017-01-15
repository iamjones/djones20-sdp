import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * When the main method is run this class will:
 * -
 */
public class ObjectReader {

    public static void main(String[] args) {

        System.out.println("Enter the name of a class or interface (e.g String, List, HashMap): ");

        Scanner in        = new Scanner(System.in);
        String className  = in.next();

        System.out.println("You entered: " + className);

        try {
            // Emit the interface of the class entered
            Class enteredClass = Class.forName(className);

            // Interface or class?
            if (enteredClass.isInterface()) {
                System.out.println(className + " is an interface.");
            } else {
                System.out.println(className + " is a class.");
            }

            // Modifiers
            int modifiers = enteredClass.getModifiers();

            if (Modifier.isPublic(modifiers)) {
                System.out.println("Object is public.");
            }

            if (Modifier.isFinal(modifiers)) {
                System.out.println("Object is final.");
            }

            if (Modifier.isAbstract(modifiers)) {
                System.out.println("Object is abstract");
            }

            if (Modifier.isPrivate(modifiers)) {
                System.out.println("Object is private");
            }

            if (Modifier.isInterface(modifiers)) {
                System.out.println("Object is interface");
            }

            if (Modifier.isNative(modifiers)) {
                System.out.println("Object is native");
            }

            if (Modifier.isProtected(modifiers)) {
                System.out.println("Object is protected");
            }

            if (Modifier.isStatic(modifiers)) {
                System.out.println("Object is static");
            }

            if (Modifier.isStrict(modifiers)) {
                System.out.println("Object is strict");
            }

            if (Modifier.isSynchronized(modifiers)) {
                System.out.println("Object is synchronised");
            }

            if (Modifier.isTransient(modifiers)) {
                System.out.println("Object is transient");
            }

            if (Modifier.isVolatile(modifiers)) {
                System.out.println("Object is volatile");
            }

            // Constructors
            Constructor[] constructors = enteredClass.getConstructors();
            System.out.println(constructors.length + " constructors available.");

            // Methods
            Method[] methods = enteredClass.getMethods();
            System.out.println(methods.length + " methods are available.");
            if (methods.length > 0) {
                System.out.println("Methods are: ");
                for (Method m : methods) {
                    System.out.println("- " + m.getName());
                }
            }

            // Fields
            Field[] fields = enteredClass.getFields();
            System.out.println(fields.length + " fields are available.");
            if (fields.length > 0) {
                System.out.println("Fields are: ");
                for (Field f : fields) {
                    System.out.println("- " + f.getName());
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Class with the name '" + className + "' was not found.");
        }

        System.out.println("The script will not exit.");
    }
}
