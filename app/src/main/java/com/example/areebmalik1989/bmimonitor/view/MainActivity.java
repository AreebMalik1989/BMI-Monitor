package com.example.areebmalik1989.bmimonitor.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.areebmalik1989.bmimonitor.R;
import com.example.areebmalik1989.bmimonitor.model.Person;
import com.example.areebmalik1989.bmimonitor.model.calculator.BmiCalculator;
import com.example.areebmalik1989.bmimonitor.model.calculator.IBmiCalculator;
import com.example.areebmalik1989.bmimonitor.model.converter.Converter;
import com.example.areebmalik1989.bmimonitor.model.converter.IConverter;

public class MainActivity extends AppCompatActivity implements IMainActivityView{

    IBmiCalculator bmiCalculator;
    IConverter converter;

    public MainActivity(){
        bmiCalculator = new BmiCalculator();
        converter = new Converter();
    }

    public MainActivity(IBmiCalculator bmiCalculator, IConverter converter){
        this.bmiCalculator = bmiCalculator;
        this.converter = converter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
