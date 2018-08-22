package com.example.areebmalik1989.bmimonitor.model.util;

import android.os.Bundle;

import com.example.areebmalik1989.bmimonitor.model.BMI;
import com.example.areebmalik1989.bmimonitor.model.Units;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BmiManagerTest {

    IBmiManager bmiManager;

    @Before
    public void setUp() throws Exception {
        bmiManager = new BmiManager();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test(){
        bmiManager.collectBmiData(80.0, Units.WeightUnit.KG.toString(),
                2.0, Units.LengthUnit.METER.toString());

        Bundle bundle = bmiManager.giveBmiResult();

        double bmi = bundle.getDouble(IBmiManager.BMI);
        String bmiTranslation = bundle.getString(IBmiManager.BMI_TRANSLATION);

        Assert.assertEquals(20.0, bmi);
        Assert.assertEquals(BMI.NORMAL.toString(), bmiTranslation);
    }
}