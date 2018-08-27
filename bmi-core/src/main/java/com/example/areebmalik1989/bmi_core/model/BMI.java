package com.example.areebmalik1989.bmi_core.model;

public enum BMI {

    VERY_SEVERELY_UNDERWEIGHT("Very Severely Underweight"),
    SEVERELY_UNDERWEIGHT("Severely Underweight"),
    UNDERWEIGHT("Underweight"),
    NORMAL("Normal Weight"),
    OVER_WEIGHT("Overweight"),
    OBESE_I("Class-I Obese"),
    OBESE_II("Class-II Obese"),
    OBESE_III("Class-III Obese"),
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
