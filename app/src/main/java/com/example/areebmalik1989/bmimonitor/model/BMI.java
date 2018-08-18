package com.example.areebmalik1989.bmimonitor.model;

public enum BMI {

    VERY_SEVERELY_UNDERWEIGHT("Very Severely Underweight"),
    SEVERELY_UNDERWEIGHT("Severely Underweight"),
    UNDERWEIGHT("Underweight"),
    NORMAL("Normal"),
    OVER_WEIGHT("Overweight"),
    OBESE_I("Obese I"),
    OBESE_II("Obese II"),
    OBESE_III("Obese III"),
    UNKNOWN("Unknown");

    private String bmi;

    BMI(String bmi){
        this.bmi = bmi;
    }

    @Override
    public String toString() {
        return bmi;
    }
}
