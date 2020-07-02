package com.example.aida.models.dateTimeModels;

import org.junit.Test;

import static org.junit.Assert.*;

public class VTimeTest {

    @Test
    public void toStringSingleDigitMinuteHour() {
        VTime time1 = new VTime(0, 1, 2);
        assertEquals("02:01", time1.toString());
    }

    @Test
    public void toStringDoubleDigitMinuteHour() {
        VTime time1 = new VTime(0, 15, 10);
        assertEquals("10:15", time1.toString());
    }

    @Test
    public void toStringDoubleDigitMinute() {
        VTime time1 = new VTime(0, 15, 5);
        assertEquals("05:15", time1.toString());
    }

    @Test
    public void toStringDoubleDigitHour() {
        VTime time1 = new VTime(0, 5, 10);
        assertEquals("10:05", time1.toString());
    }

    @Test
    public void constructorDefault() {
        VTime time1 = new VTime();
        assertEquals("00:00", time1.toString());
    }

    @Test
    public void constructorStringValid() {

    }

    @Test
    public void constructorStringInvalid() {

    }

    @Test
    public void constructorNumericalValid() {
        VTime time1 = new VTime(0, 0, 0);
        VTime time2 = new VTime(0, 15, 6);
        VTime time3 = new VTime(0, 30, 12);
        VTime time4 = new VTime(0, 45, 18);
        VTime time5 = new VTime(0, 59, 23);

        assertEquals("00:00", time1.toString());
        assertEquals("06:15", time2.toString());
        assertEquals("12:30", time3.toString());
        assertEquals("18:45", time4.toString());
        assertEquals("23:59", time5.toString());
    }

    @Test
    public void constructorNumericalInvalid() {
        VTime time1 = new VTime(0, -1, -1);
        VTime time2 = new VTime(0, -1, 10);
        VTime time3 = new VTime(0, 15, -5);
        VTime time4 = new VTime(0, 60, 10);
        VTime time5 = new VTime(0, 15, 27);
        VTime time6 = new VTime(0, 60, 24);

        assertEquals("00:00", time1.toString());
        assertEquals("10:00", time2.toString());
        assertEquals("00:15", time3.toString());
        assertEquals("10:59", time4.toString());
        assertEquals("23:15", time5.toString());
        assertEquals("23:59", time6.toString());
    }
}