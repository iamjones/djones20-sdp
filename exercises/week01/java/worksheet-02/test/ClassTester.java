import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.fail;

public class ClassTester {

    private Class classUnderTest;

    @BeforeEach
    public void setUp() {
        try {
            this.classUnderTest = Class.forName("FailureClass");
        } catch(ClassNotFoundException e) {
            fail("Test cannot be started.");
        }
    }

    @Test
    public void class_should_contain_less_than_or_equal_to_four_fields() {

        Field[] fields = this.classUnderTest.getDeclaredFields();

        assertThat(fields.length, lessThan(5));
    }

    @Test
    public void class_should_not_contain_any_non_private_fields() {

        Field[] fields = this.classUnderTest.getFields();

        assertThat(fields.length, is(0));
    }

    @Test
    public void class_should_not_contain_any_fields_that_are_of_type_arraylist() {

        Field[] fields = this.classUnderTest.getDeclaredFields();

        for (Field f : fields) {

            String fieldType = f.getType().getSimpleName();

            assertThat(fieldType, not("ArrayList"));
        }
    }

    @Test
    public void class_should_have_at_least_two_private_methods() {

        Method[] methods = this.classUnderTest.getDeclaredMethods();

        int count = 0;

        for (Method m: methods) {

            int modifier = m.getModifiers();

            if (Modifier.isPrivate(modifier)) {
                count++;
            }
        }

        assertThat(count, is(2));
    }

    @Test
    public void class_should_not_contain_a_method_that_has_a_throw_clause() {

        Method[] methods = this.classUnderTest.getDeclaredMethods();

        for (Method m : methods) {
            Class[] exceptionTypes = m.getExceptionTypes();

            assertThat(exceptionTypes.length, is(0));
        }
    }

    @Test
    public void class_should_not_contain_a_method_that_returns_an_int() {

        Method[] methods = this.classUnderTest.getDeclaredMethods();

        for (Method m : methods) {
            assertThat(m.getReturnType().getSimpleName(), not("int"));
        }
    }

    @Test
    public void class_should_contain_a_zero_argument_constructor() {

        Constructor[] constructors = this.classUnderTest.getConstructors();

        boolean hasZeroArgumentConstructor = false;

        for (Constructor c : constructors) {
            if (c.getParameterCount() == 0) {
                hasZeroArgumentConstructor = true;
            }
        }

        assertThat(hasZeroArgumentConstructor, is(true));
    }
}
