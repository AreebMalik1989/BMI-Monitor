package com.example.areebmalik1989.bmimonitor.model;

public class Weight {

    private double weight;
    private Units.WeightUnit weightUnit;

    public Weight(int weight, Units.WeightUnit weightUnit) {
        this.weight = weight;
        this.weightUnit = weightUnit;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Units.WeightUnit getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(Units.WeightUnit weightUnit) {
        this.weightUnit = weightUnit;
    }
}
