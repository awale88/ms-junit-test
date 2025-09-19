package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    @DisplayName("Addition Test")
    public void testAddition() {
        int expected = 5;
        int actual = calculator.addition(2, 3);
        assertEquals(actual, expected);
    }

    @Test
    @DisplayName("Subtraction Test")
    public void testSubtraction() {
        int expected = -1;
        int actual = calculator.subtraction(-5, -4);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Multiplication Test")
    public void testMultiplication() {
        int expected = 6;
        int actual = calculator.multiplication(2, 3);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Division Test")
    public void testDivision() {
        int expected = 2;
        int actual = calculator.division(4, 2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, -2, -1000, 100000})
    @DisplayName("Test Even Number")
    public void testIsEven(int numbers) {
        boolean actual = calculator.isEven(numbers);
        assertTrue(actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 7})
    @DisplayName("Test Odd Number")
    public void testIsOdd(int numbers) {
        boolean actual = calculator.isEven(numbers);
        assertFalse(actual);
    }

    @Test
    @DisplayName("Arrays Test")
    public void testIncrementArray() {
        int[] expected = new int[]{2, 3, 4};
        int[] actual = calculator.incrementArray(new int[]{1, 2, 3});
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSquareRootException(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.squareRoot(-9));
        String expected = "Cannot calculate square root of negative number";
        String actual = exception.getMessage();
        assertEquals(expected, actual);

    }

    @Test
    public void testSquareRoot(){
        double expected = 3;
        double actual = calculator.squareRoot(9);
        assertEquals(expected, actual);
    }

    @Test
    public void testFactorial(){
        assertEquals(calculator.factorial(5), 120);
        assertThat(calculator.factorial(0), equalTo(1.0));
    }

    @Test
    public void testFactorialException(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-5));
        String expected = "Factorial is not defined for negative numbers";
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Exception Test")
    public void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.division(1, 0));
        String expected = "Digits cannot be divided by zero";
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    public void testSimpleInterest(){
        int expected = 150;
        int actual = calculator.simpleInterestCalculation(1000, 3, 5);
        assertEquals(expected, actual);
    }
}
