import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
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

        Field[] fields = this.classUnderTest.getFields();

        assertThat(fields.length, lessThan(5));
    }

    @Test
    public void class_should_not_contain_any_non_private_fields() {

    }

    @Test
    public void class_should_not_contain_any_fields_that_are_of_type_arraylist() {

    }

    @Test
    public void class_should_have_at_least_two_private_methods() {

    }

    @Test
    public void class_should_not_contain_a_method_that_has_a_throw_clause() {

    }

    @Test
    public void class_should_not_contain_a_method_that_returns_an_int() {

    }

    @Test
    public void class_should_contain_a_zero_argument_constructor() {

    }

}
