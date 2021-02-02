package be.intecbrussel.calculator;
import be.intecbrussel.calculator.TestApp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
public class TestAppTest {

    private final TestApp testApp = new TestApp();

    //basistestmethode ; geen parameters
    @Test
    @Disabled ("cuzz I said so")
    void addTestTwoAndTwo(){
        //hier komt de code om de test uit te voeren
        int a = 2;
        int b = 2;
        int expectedResult = 4;

        Assertions.assertEquals(expectedResult, testApp.add(a,b));

    }
    @Test
    void addTestNegativeWithPositive(){
        int a = 2;
        int b = -2;
        int expectedResult = 0;

        Assertions.assertEquals(expectedResult,testApp.add(a,b));
    }
    @Test
    void addTestTwoNegativeNumbers(){
        int a = -2;
        int b = -2;
        int expectedResult = -4;

        Assertions.assertEquals(expectedResult,testApp.add(a,b));
    }

    @Test
    void addTestZero(){
        int a = 0;
        int b = 0;
        int expectedResult = 0;

        Assertions.assertEquals(expectedResult,testApp.add(a,b));
    }



}
