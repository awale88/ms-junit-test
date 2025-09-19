package org.example;

public class Calculator {

    public int addition(int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
        return a - b;
    }

    public int multiplication(int a, int b) {
        return a * b;
    }

    public int division(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Digits cannot be divided by zero");
        }
        return a / b;
    }

    public double squareRoot(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(number);
    }

    public boolean isEven(int i) {
        return i % 2 == 0;
    }

    public int[] incrementArray(int[] values) {

        int[] newValues = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            newValues[i] = values[i] + 1;
        }
        return newValues;
    }

    public int simpleInterestCalculation(int p, int t, int r) {
        return p * t * r / 100;
    }

    public double factorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (number == 0 || number == 1) {
            return 1;
        }
        double result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
