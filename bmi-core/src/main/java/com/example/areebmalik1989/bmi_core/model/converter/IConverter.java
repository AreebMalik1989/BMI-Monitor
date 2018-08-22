package com.example.areebmalik1989.bmi_core.model.converter;

import com.example.areebmalik1989.bmi_core.model.Height;
import com.example.areebmalik1989.bmi_core.model.Weight;

public interface IConverter {
    double convertHeight(Height height);
    double convertWeight(Weight weight);
}
