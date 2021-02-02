package be.intecbrussel.calculator;

import be.intecbrussel.calculator.Calculator;
import be.intecbrussel.calculator.NotEnoughNumbersException;
import be.intecbrussel.calculator.TooManyNumbersException;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    //is executed before all tests
    public void initializeCalculator() {
        calculator = new Calculator();
    }


    @BeforeEach
    public void resetCalculator() {
        calculator.clear();
        System.out.println("Beginning Test");
    }


    @AfterEach
    public void testClear() {
        System.out.println("Test finished");
    }

    @AfterAll
    public void testDone() {
        System.out.println("All tests are finished");
    }


    @Test
    public void testSumOfManyNumbers2() {
        calculator.addNumbers(5, 8, 6, 1, 96, 84, 156, 15, 56);
        calculator.addition();
        double result = calculator.getResult();

        Assertions.assertEquals(427, result);
    }

    @Test
    public void testSubtractionWithTwoNumbers() throws TooManyNumbersException, NotEnoughNumbersException {

        calculator.addNumbers(10, 7);
        calculator.subtraction();
        double result = calculator.getResult();

        Assertions.assertEquals(3, result);
    }

    @Test
    public void testSubtractionWithMoreThanTwoNumbers() {
        calculator.addNumbers(10, 7, 3);
        Assertions.assertThrows(TooManyNumbersException.class, () -> {
            calculator.subtraction();
        });
    }


    @Test
    public void testMultiplicationWithoutZero() {
        calculator.addNumbers(10, 7, 80);
        calculator.multiplication();
        double result = calculator.getResult();

        Assertions.assertEquals(5600, result);
    }

    @Test

    public void testDivisionWithTwoNumbers() throws NotEnoughNumbersException, TooManyNumbersException {
        calculator.addNumbers(10, 2);
        calculator.division();
        double result = calculator.getResult();

        Assertions.assertEquals(5, result);
    }


    @Test
    public void testDivisionWithMoreThanTwoNumbers() {
        calculator.addNumbers(10, 7, 3);

        Assertions.assertThrows(TooManyNumbersException.class, () -> calculator.division());
    }

    @Test
    public void testDivisionWithZero() {
        calculator.addNumbers(10, 0);

        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.division();
        });

    }

    @Test
    public void testPower() {
        calculator.addNumbers(10, 2, 3, 4);
        calculator.power();
        double result = calculator.getResult();

        Assertions.assertEquals(1_000_000_000_000_000_000_000_000D, result);
    }


    @Test


    public void testSquareRootPositiveOneNumberPositiveResult() {
        calculator.addNumbers(25);
        calculator.squareRoot();
        double result = calculator.getResult();

        Assertions.assertEquals(5, result);
    }

            /*@Test
            public void testSquareRootNegativeOneNumberPositiveResult () {
                calculator.addNumbers(-25);
                calculator.squareRoot();
                double result = calculator.getResult();

                Assertions.assertEquals(5, result
                );
            }*/

    @Test
    public void tstClear() {
        calculator.addNumbers(5, 5, 5, 5, 5, 5, 54);
        calculator.clear();

        Assertions.assertTrue(calculator.getNumbers().size() == 0);
        Assertions.assertTrue(calculator.getNumbers().size() == 0);

    }

}


