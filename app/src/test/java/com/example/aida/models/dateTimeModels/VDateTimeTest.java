package com.example.aida.models.dateTimeModels;

import org.junit.Test;

import static org.junit.Assert.*;

public class VDateTimeTest {

    @Test
    public void toStringDefault() {
        VDateTime dateTime = new VDateTime(new VDate(1, 1, 1066), new VTime(0, 7, 7));
        assertEquals("07:07 - 01/01/1066", dateTime.toString());
    }

    @Test
    public void constructorDefault() {
        VDateTime dateTime = new VDateTime();
        assertEquals("00:00 - 01/01/0001", dateTime.toString());
    }

    @Test
    public void constructorParamsValid() {
        VDateTime dateTime = new VDateTime(new VDate(1, 1, 1066), new VTime(0, 7, 7));
        assertEquals("07:07 - 01/01/1066", dateTime.toString());
    }

    @Test
    public void constructorParamsNull() {
        VDateTime dateTime = new VDateTime(null, null);
        assertEquals("00:00 - 01/01/0001", dateTime.toString());
    }
}