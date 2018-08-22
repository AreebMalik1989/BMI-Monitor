package com.example.areebmalik1989.bmimonitor.view.fragment.bmiFragment;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.areebmalik1989.bmimonitor.model.calculator.BmiCalculator;
import com.example.areebmalik1989.bmimonitor.model.calculator.IBmiCalculator;
import com.example.areebmalik1989.bmimonitor.model.converter.Converter;
import com.example.areebmalik1989.bmimonitor.model.converter.IConverter;
import com.example.areebmalik1989.bmimonitor.view.fragment.BmiFragment;
import com.example.areebmalik1989.bmimonitor.view.fragment.IBmiFragment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class BmiFragmentTest {

    IBmiCalculator bmiCalculator;
    IConverter converter;

    TextView bmiOutput;
    EditText weightEditText, heightEditText;
    Spinner weightSpinner, heightSpinner;

    IBmiFragment bmiFragment;

    @Before
    public void setUp() throws  Exception {

        this.bmiCalculator = new BmiCalculator();
        this.converter = new Converter();
        this.bmiOutput = Mockito.mock(TextView.class);
        this.weightEditText = Mockito.mock(EditText.class);
        this.heightEditText = Mockito.mock(EditText.class);
        this.weightSpinner = Mockito.mock(Spinner.class);
        this.heightSpinner = Mockito.mock(Spinner.class);

        this.bmiFragment = new BmiFragment();
    }

    @Test
    public void shouldSetWeightSpinner(){
    }

    @Test
    public void shouldSetHeightSpinner(){}

}
