package com.example.areebmalik1989.bmimonitor.model.calculator;

import com.example.areebmalik1989.bmimonitor.model.BMI;
import com.example.areebmalik1989.bmimonitor.model.Person;

public class BmiCalculator implements IBmiCalculator {

    @Override
    public double calculateBmi(double height, double weight) {

        if(height<=0 || weight<=0){
            return -1.0;
        }

        return weight / (height*height);
    }

    @Override
    public BMI translateBmi(double bmi) {

        if (bmi < 16) return BMI.VERY_SEVERELY_UNDERWEIGHT;
        else if (bmi < 17) return BMI.SEVERELY_UNDERWEIGHT;
        else if (bmi < 18.5) return BMI.UNDERWEIGHT;
        else if (bmi < 25) return BMI.NORMAL;
        else if (bmi < 30) return BMI.OVER_WEIGHT;
        else if (bmi < 35) return BMI.OBESE_I;
        else if (bmi < 40) return BMI.OBESE_II;
        else if (bmi >= 40) return BMI.OBESE_III;

        return BMI.UNKNOWN;
    }
}
