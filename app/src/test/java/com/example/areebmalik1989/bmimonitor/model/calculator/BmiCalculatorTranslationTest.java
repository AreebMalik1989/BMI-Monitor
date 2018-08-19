package com.example.areebmalik1989.bmimonitor.model.calculator;

import com.example.areebmalik1989.bmimonitor.model.BMI;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BmiCalculatorTranslationTest {

    IBmiCalculator bc;

    double bmiValue;
    BMI bmiTraslation;

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][] {
                {15, BMI.VERY_SEVERELY_UNDERWEIGHT},
                {16, BMI.SEVERELY_UNDERWEIGHT},
                {16.9, BMI.SEVERELY_UNDERWEIGHT},
                {17.0, BMI.UNDERWEIGHT},
                {18.4, BMI.UNDERWEIGHT},
                {18.5, BMI.NORMAL},
                {24.9, BMI.NORMAL},
                {25.0, BMI.OVER_WEIGHT},
                {29.9, BMI.OVER_WEIGHT},
                {30.0, BMI.OBESE_I},
                {34.9, BMI.OBESE_I},
                {35.0, BMI.OBESE_II},
                {39.9, BMI.OBESE_II},
                {40.0, BMI.OBESE_III},
                {41, BMI.OBESE_III}
        });
    }

    public BmiCalculatorTranslationTest(double bmiValue, BMI bmiTraslation){
        this.bmiValue = bmiValue;
        this.bmiTraslation = bmiTraslation;
    }

    @Before
    public void setUp() throws Exception {
        bc = new BmiCalculator();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void translateBmi() {

        BMI bmi = bc.translateBmi(bmiValue);

        Assert.assertTrue("bmi is not correct,\nacutal value: " + bmi +
                "\nexpected value: " + bmiTraslation, bmi.equals(bmiTraslation));
    }
}