import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class ObjectCreator {

    public static void main(String[] args) {

        System.out.println("Enter the name of a class to create an instance of: ");

        Scanner in        = new Scanner(System.in);
        String className  = in.next();

        System.out.println("Enter the value of a parameter: ");

        String parameter  = in.next();

        System.out.println("You entered: " + className);
        System.out.println("With a parameter of: " + parameter);

        try {
            Class enteredClass = Class.forName(className);

            Constructor classConstructor = enteredClass.getConstructor(String.class);

            Object createdObject = classConstructor.newInstance(parameter);

            System.out.println(createdObject);

        } catch(ClassNotFoundException e) {
            System.out.println("Class named '" + className + "' was not found.");
        } catch(NoSuchMethodException e) {
            System.out.println("There is not a constructor for the class '" + className + "'");
        } catch(InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Class could not be instantiated.");
        }
    }
}
