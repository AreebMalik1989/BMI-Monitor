package com.example.areebmalik1989.bmi_core.model.converter;

import com.example.areebmalik1989.bmi_core.model.Height;
import com.example.areebmalik1989.bmi_core.model.Weight;

public class Converter implements IConverter {

    @Override
    public double convertHeight(Height h) {

        switch (h.getLengthUnit()){
            case METER:
                return h.getHeight();
            case INCH:
                return h.getHeight() * 0.0254;
            case CENTIMETER:
                return h.getHeight() * 0.01;
            default:
                    return -1;
        }
    }

    @Override
    public double convertWeight(Weight weight) {

        switch (weight.getWeightUnit()){
            case KG:
                return weight.getWeight();
            case POUND:
                return weight.getWeight() * 0.453592;
            default:
                    return -1;
        }
    }
}
