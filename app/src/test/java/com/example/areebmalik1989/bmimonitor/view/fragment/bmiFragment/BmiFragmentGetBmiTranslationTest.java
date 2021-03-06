package com.example.areebmalik1989.bmimonitor.view.fragment.bmiFragment;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.areebmalik1989.bmimonitor.model.BMI;
import com.example.areebmalik1989.bmimonitor.model.Height;
import com.example.areebmalik1989.bmimonitor.model.Units;
import com.example.areebmalik1989.bmimonitor.model.Weight;
import com.example.areebmalik1989.bmimonitor.model.calculator.BmiCalculator;
import com.example.areebmalik1989.bmimonitor.model.calculator.IBmiCalculator;
import com.example.areebmalik1989.bmimonitor.model.converter.Converter;
import com.example.areebmalik1989.bmimonitor.model.converter.IConverter;
import com.example.areebmalik1989.bmimonitor.view.fragment.BmiFragment;
import com.example.areebmalik1989.bmimonitor.view.fragment.IBmiFragment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BmiFragmentGetBmiTranslationTest {

    IBmiCalculator bmiCalculator;
    IConverter converter;

    TextView bmiOutput;
    EditText weightEditText, heightEditText;
    Spinner weightSpinner, heightSpinner;

    IBmiFragment bmiFragment;

    Weight weight;
    Height height;
    BMI bmi;

    @Parameterized.Parameters
    public static Collection data(){
        return Arrays.asList(new Object[][]{
                {new Weight(8, Units.WeightUnit.KG), new Height(2, Units.LengthUnit.METER), BMI.VERY_SEVERELY_UNDERWEIGHT}
        });
    }

    public BmiFragmentGetBmiTranslationTest(Weight weight, Height height, BMI bmi){
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

    @Test
    public void shouldGetBmiTranslation(){
    }
}