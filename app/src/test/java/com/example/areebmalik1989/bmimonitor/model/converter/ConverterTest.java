package com.example.areebmalik1989.bmimonitor.model.converter;

import com.example.areebmalik1989.bmimonitor.model.Height;
import com.example.areebmalik1989.bmimonitor.model.Units;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConverterTest {

    IConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new Converter();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void convertHeight() {

        Height h = new Height(160, Units.LengthUnit.CENTIMETER);

        double height = converter.convertHeight(h);

        Assert.assertNotEquals(height, 0.0);
    }
}