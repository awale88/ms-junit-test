package org.example;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class HamcrestDemo {

    Calculator calculator = new Calculator();

    @Test
    public  void testAddition(){
        assertThat(calculator.addition(2, 2), equalTo(4));
        assertThat(calculator.addition(2, 2), is(not(equalTo(1))));
    }

    @Test
    public void testSubtraction(){
        assertThat(calculator.subtraction(5, 3), equalTo(2));
        assertThat(calculator.subtraction(5, 3), not(equalTo(3)));
    }

    @Test
    public void testDivision(){
        assertThat(calculator.division(4, 2), not(5));
        assertThat(calculator.division(4, 2), is(2));
    }

    @Test
    public void testIsEven(){
        assertThat(calculator.isEven(5), is(not(true)));
        assertThat(calculator.isEven(5), not(true));
        assertThat(calculator.isEven(5), is(false));
    }

    @Test
    public void testIsOdd(){
        assertThat(calculator.isEven(3), is(equalTo(false)));
    }

    @Test
    public void testNotNullValue(){
        assertThat(calculator.division(2, 2), is(notNullValue()));
        assertThat(calculator.addition(2, 2), is(notNullValue()));
        assertThat(calculator.subtraction(2, 2), is(notNullValue()));
        assertThat(calculator.multiplication(2, 2), notNullValue());
    }
}
