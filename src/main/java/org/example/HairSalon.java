package org.example;

import java.util.Arrays;

public class HairSalon {

    private Day[] openingDays = {Day.MONDAY, Day.TUESDAY};
    private int hairCutPrice = 30;
    private Calculator calculator = new Calculator();

    public Day[] getOpeningDays() {
        return openingDays;
    }

    public boolean isOpen(Day weekDay) {
        if (Arrays.asList(openingDays).contains(weekDay)) {
            return true;
        } else {
            return false;
        }
    }

    public int getHairCutPrice() {
        return hairCutPrice;
    }

    public int applyDiscount() {
        return calculator.division(hairCutPrice, 2) + 5;
    }

    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }
}
