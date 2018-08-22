package com.example.areebmalik1989.bmi_core.model.calculator;

import com.example.areebmalik1989.bmi_core.model.BMI;

public interface IBmiCalculator {
    double calculateBmi(double height, double weight);
    BMI translateBmi(double bmi);
}
