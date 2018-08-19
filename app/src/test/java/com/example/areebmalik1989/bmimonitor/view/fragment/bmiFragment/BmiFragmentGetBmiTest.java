package com.example.areebmalik1989.bmimonitor.view.fragment.bmiFragment;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.areebmalik1989.bmimonitor.model.Height;
import com.example.areebmalik1989.bmimonitor.model.Units;
import com.example.areebmalik1989.bmimonitor.model.Weight;
import com.example.areebmalik1989.bmimonitor.model.calculator.BmiCalculator;
import com.example.areebmalik1989.bmimonitor.model.calculator.IBmiCalculator;
import com.example.areebmalik1989.bmimonitor.model.converter.Converter;
import com.example.areebmalik1989.bmimonitor.model.converter.IConverter;
import com.example.areebmalik1989.bmimonitor.view.fragment.BmiFragment;
import com.example.areebmalik1989.bmimonitor.view.fragment.IBmiFragment;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BmiFragmentGetBmiTest {

    IBmiCalculator bmiCalculator;
    IConverter converter;

    TextView bmiOutput;
    EditText weightEditText, heightEditText;
    Spinner weightSpinner, heightSpinner;

    IBmiFragment bmiFragment;

    Weight weight;
    Height height;
    double bmi;

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
                {new Weight(8, Units.WeightUnit.KG), new Height(2, Units.LengthUnit.METER), 2.0}
        });
    }

    public BmiFragmentGetBmiTest(Weight weight, Height height, double bmi){
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
    }

    @Before
    public void setUp() throws Exception {

        bmiCalculator = new BmiCalculator();
        converter = new Converter();

        bmiFragment = new BmiFragment();
    }

    @After
    public void tearDown() throws Exception {
    }
}