package be.intecbrussel.dynamic;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FactorialTest {

    private Factorial factorial;

    @BeforeAll
    public void initialize() {
        factorial = new Factorial();
    }

    @BeforeEach
    void beforeEach(TestInfo info) {
        System.out.println("Before execute "+info.getTestMethod().get().getName());
    }
    //First I tested my method with various static tests -- also to get more fluent in writing methods into tests
    @Test
    public void factorialZero() {
        Factorial f = new Factorial();
        int expected = 1;
        int actual = f.fact(0);
        assertEquals(expected, actual);
    }

    @Test
    public void factorialTwo() {
        Factorial f = new Factorial();
        int expected = 2;
        int actual = f.fact(2);
        assertEquals(expected, actual);
    }


    @Test
    public void factorialFive() {
        Factorial f = new Factorial();
        int expected = 120;
        int actual = f.fact(5);
        assertEquals(expected, actual);
    }
    // This method produces Dynamic test cases
    @TestFactory
    Collection<DynamicTest> dynamicTestsForFactorialMethod() {
        List<DynamicTest> dynamicTests = Arrays.asList(
                dynamicTest("1st dynamic test _ Test Boolean Condition", () -> assertTrue(true)),
                dynamicTest("2nd dynamic test _ Test Positive Integer", () -> assertEquals(24, factorial.fact(4))),
                dynamicTest("3d dynamic test _ Test With Result Not Null", () -> assertNotNull(factorial.fact(12))),
                dynamicTest("4th dynamic test _ Test With Zero", () -> assertEquals(1, factorial.fact(0))),
                dynamicTest("5th dynamic test _ Test With Negative Integer", () -> assertEquals(1, factorial.fact(-12)))
        );
        sortDynamicTests(dynamicTests);
        return dynamicTests;
    }
    static void sortDynamicTests(List<DynamicTest> dynamicTests) {
        dynamicTests.sort((DynamicTest d1, DynamicTest d2) ->
                d2.getDisplayName().compareTo(d1.getDisplayName()));
    }

    @AfterEach
    void afterEach(TestInfo info) {
        System.out.println("After execute "+info.getTestMethod().get().getName());
    }

}

