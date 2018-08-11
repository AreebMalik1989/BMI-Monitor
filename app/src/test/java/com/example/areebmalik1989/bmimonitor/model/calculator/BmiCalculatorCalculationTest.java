package com.example.areebmalik1989.bmimonitor.model.calculator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BmiCalculatorCalculationTest {

    IBmiCalculator bc;

    double height;
    double weight;
    double bmi;

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
                {0.0, 0.0, -1.0},
                {-1.0, -1.0, -1.0},
                {-1.0, 0.0, -1.0},
                {0.0, -1.0, -1.0},
        });
    }

    public BmiCalculatorCalculationTest(double height, double weight, double bmi){
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
    }

    @Before
    public void setUp() throws Exception {
        bc = new BmiCalculator();
    }

    @After
    public void tearDown() throws Exception {}



    @Test
    public void calculateBmi() {

        double calculatedBmi = bc.calculateBmi(height, weight);

        System.out.println("height: " + height);
        System.out.println("weight: " + weight);
        System.out.println("bmi: " + bmi);
        System.out.println("calculatedBmi: " + calculatedBmi);

        Assert.assertTrue(bmi == calculatedBmi);
    }
}
