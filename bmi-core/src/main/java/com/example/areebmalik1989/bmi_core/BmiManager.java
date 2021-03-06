package com.example.areebmalik1989.bmi_core;

import com.example.areebmalik1989.bmi_core.model.Height;
import com.example.areebmalik1989.bmi_core.model.Units;
import com.example.areebmalik1989.bmi_core.model.Weight;
import com.example.areebmalik1989.bmi_core.model.calculator.BmiCalculator;
import com.example.areebmalik1989.bmi_core.model.calculator.IBmiCalculator;
import com.example.areebmalik1989.bmi_core.model.converter.Converter;
import com.example.areebmalik1989.bmi_core.model.converter.IConverter;

public class BmiManager implements IBmiManager {

    String bmiTranslation;
    double bmi;

    IBmiCalculator bmiCalculator;
    IConverter converter;

    public BmiManager(){
        bmiCalculator = new BmiCalculator();
        converter = new Converter();
    }

    @Override
    public void collectBmiData(double weight, String weightType, double height, String heightType) {

        Weight w = new Weight(weight, getWeightUnit(weightType));
        Height h = new Height(height, getHeightUnit(heightType));

        bmi = bmiCalculator.calculateBmi(converter.convertHeight(h), converter.convertWeight(w));
        bmiTranslation = bmiCalculator.translateBmi(bmi).toString();
    }

    @Override
    public double giveBmi() {
        return bmi;
    }

    @Override
    public String giveBmiTranslation() {
        return bmiTranslation;
    }

    public static Units.LengthUnit getHeightUnit(String heightType){

        if(heightType.equals(Units.LengthUnit.METER.toString())){
            return Units.LengthUnit.METER;
        } else if(heightType.equals(Units.LengthUnit.CENTIMETER.toString())){
            return Units.LengthUnit.CENTIMETER;
        } else if(heightType.equals(Units.LengthUnit.INCH.toString())){
            return Units.LengthUnit.INCH;
        } else if(heightType.equals(Units.LengthUnit.FOOT_INCH.toString())){
            return Units.LengthUnit.FOOT_INCH;
        }

        return Units.LengthUnit.UNKNOWN;
    }

    public static Units.WeightUnit getWeightUnit(String weightType){

        if(weightType.equals(Units.WeightUnit.KG.toString())){
            return Units.WeightUnit.KG;
        } else if(weightType.equals(Units.WeightUnit.POUND.toString())){
            return Units.WeightUnit.POUND;
        } else if(weightType.equals(Units.WeightUnit.STONE_POUND.toString())){
            return Units.WeightUnit.STONE_POUND;
        }

        return Units.WeightUnit.UNKNOWN;
    }
}
