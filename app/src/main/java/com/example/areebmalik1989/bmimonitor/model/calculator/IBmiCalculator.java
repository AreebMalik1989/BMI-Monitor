package com.example.areebmalik1989.bmimonitor.model.calculator;

import com.example.areebmalik1989.bmimonitor.model.BMI;
import com.example.areebmalik1989.bmimonitor.model.Person;

public interface IBmiCalculator {
    double calculateBmi(double height, double weight);
    BMI translateBmi(double bmi);
}
