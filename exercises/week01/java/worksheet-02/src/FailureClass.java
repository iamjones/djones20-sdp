import java.util.ArrayList;

/**
 * Class to be used in the ClassTester test.
 * Every test should fail when testing this class.
 */
public class FailureClass {

    public ArrayList myList;

    private String param;

    private String param2;

    private String param3;

    private String param4;

    private String param5;

    public FailureClass(ArrayList myList) {
        this.myList = myList;
    }

    public int returnInt() {
        return 1;
    }

    public void throwSomething() throws IllegalArgumentException {
        throw new IllegalArgumentException("Bad argument");
    }

    private void myHelperMethod() {

    }
}
