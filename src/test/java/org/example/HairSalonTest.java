package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class HairSalonTest {

    HairSalon hairSalon = new HairSalon();

    @Test
    public void testGetOpeningDays() {
        HairSalon.Day[] expected = new HairSalon.Day[]{HairSalon.Day.MONDAY, HairSalon.Day.TUESDAY};
        HairSalon.Day[] actual = hairSalon.getOpeningDays();
        assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @EnumSource(value = HairSalon.Day.class, names = {"MONDAY", "TUESDAY"})
    public void testSalonIsOpen(HairSalon.Day day) {
        assertTrue(hairSalon.isOpen(day));
    }

    @ParameterizedTest
    @EnumSource(value = HairSalon.Day.class, names = {"WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"})
    public void testSalonIsClosedOn(HairSalon.Day day) {
        assertFalse(hairSalon.isOpen(day));
    }

    @Test
    public void testNull(){
        assertFalse(hairSalon.isOpen(null));
    }

    @Test
    @Disabled
    public void testExceptionIsThrownIfWeekdayDoesNotEndInDay() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> hairSalon.isOpen(HairSalon.Day.valueOf("Hello")));
        String actual = exception.getMessage();
        String expected = "The weekday argument must end in 'day'.";
        assertEquals(expected, actual);
    }

    @Test
    public void testApplyDiscount(){
        Calculator calculator = new Calculator();
        assumeTrue(calculator.division(hairSalon.getHairCutPrice(), 2) == 15);
        double expected = 20;
        double actual = hairSalon.applyDiscount();
        assertEquals(expected, actual);
    }
}
