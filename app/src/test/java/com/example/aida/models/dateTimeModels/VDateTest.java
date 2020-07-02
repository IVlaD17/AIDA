package com.example.aida.models.dateTimeModels;

import org.junit.Test;

import static org.junit.Assert.*;

public class VDateTest {

    @Test
    public void toStringSingleDigitDayMonth() {
        // Day < 10 AND Month < 10
        VDate date1 = new VDate(1, 1, 1);
        VDate date2 = new VDate(1, 1, 10);
        VDate date3 = new VDate(1, 1, 100);
        VDate date4 = new VDate(1, 1, 1000);

        assertEquals("01/01/0001", date1.toString());
        assertEquals("01/01/0010", date2.toString());
        assertEquals("01/01/0100", date3.toString());
        assertEquals("01/01/1000", date4.toString());
    }

    @Test
    public void toStringDoubleDigitDayMonth() {
        // Day >= 10 AND Month >= 10
        VDate date1 = new VDate(10, 10, 1);
        VDate date2 = new VDate(10, 10, 10);
        VDate date3 = new VDate(10, 10, 100);
        VDate date4 = new VDate(10, 10, 1000);

        assertEquals("10/10/0001", date1.toString());
        assertEquals("10/10/0010", date2.toString());
        assertEquals("10/10/0100", date3.toString());
        assertEquals("10/10/1000", date4.toString());
    }

    @Test
    public void toStringDoubleDigitDay() {
        // Day >= 10 AND Month < 10
        VDate date1 = new VDate(10, 1, 1);
        VDate date2 = new VDate(10, 1, 10);
        VDate date3 = new VDate(10, 1, 100);
        VDate date4 = new VDate(10, 1, 1000);

        assertEquals("10/01/0001", date1.toString());
        assertEquals("10/01/0010", date2.toString());
        assertEquals("10/01/0100", date3.toString());
        assertEquals("10/01/1000", date4.toString());
    }

    @Test
    public void toStringDoubleDigitMonth() {
        // Day < 10 AND Month >= 10
        VDate date1 = new VDate(1, 10, 1);
        VDate date2 = new VDate(1, 10, 10);
        VDate date3 = new VDate(1, 10, 100);
        VDate date4 = new VDate(1, 10, 1000);

        assertEquals("01/10/0001", date1.toString());
        assertEquals("01/10/0010", date2.toString());
        assertEquals("01/10/0100", date3.toString());
        assertEquals("01/10/1000", date4.toString());
    }

    @Test
    public void constructorDefault() {
        VDate date1 = new VDate();
        assertEquals("01/01/0000", date1.toString());
    }

    @Test
    public void constructorStringValid() {

    }

    @Test
    public void constructorStringInvalid() {

    }

    @Test
    public void constructorNumericalValid() {
        VDate date1 = new VDate(1, 1, 1);
        VDate date2 = new VDate(7, 3, 76);
        VDate date3 = new VDate(15, 10, 557);
        VDate date4 = new VDate(27, 11, 2020);
        VDate date5 = new VDate(31, 12, 9999);

        assertEquals("01/01/0001", date1.toString());
        assertEquals("07/03/0076", date2.toString());
        assertEquals("15/10/0557", date3.toString());
        assertEquals("27/11/2020", date4.toString());
        assertEquals("31/12/9999", date5.toString());
    }

    @Test
    public void constructorNumericalInvalid() {
        VDate date1 = new VDate(-5, -5, 0);
        VDate date2 = new VDate(-3, 0, 1066);
        VDate date3 = new VDate(0, 5, 1444);
        VDate date4 = new VDate(-3, 15, 1999);
        VDate date5 = new VDate(36, 1564, 1000056);

        assertEquals("01/01/0000", date1.toString());
        assertEquals("01/01/1066", date2.toString());
        assertEquals("01/05/1444", date3.toString());
        assertEquals("01/12/1999", date4.toString());
        assertEquals("31/12/9999", date5.toString());
    }
}