package com.example.areebmalik1989.bmimonitor.model.converter;

import com.example.areebmalik1989.bmimonitor.model.Height;
import com.example.areebmalik1989.bmimonitor.model.Weight;

public interface IConverter {
    double convertHeight(Height height);
    double convertWeight(Weight weight);
}
