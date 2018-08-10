package com.example.areebmalik1989.bmimonitor.model;

public class Height {

    private double height;
    private Units.LengthUnit lengthUnit;

    public Height(double height, Units.LengthUnit lengthUnit) {
        this.height = height;
        this.lengthUnit = lengthUnit;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Units.LengthUnit getLengthUnit() {
        return lengthUnit;
    }

    public void setLengthUnit(Units.LengthUnit lengthUnit) {
        this.lengthUnit = lengthUnit;
    }
}
