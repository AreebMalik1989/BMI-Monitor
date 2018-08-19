package com.example.areebmalik1989.bmimonitor.model.util;

import android.os.Bundle;

public interface IBmiManager {

    String BMI_TRANSLATION = "BundleString";
    String BMI = "BundleDouble";

    void collectBmiData(double weight, String weightType, double height, String heightType);
    Bundle giveBmiResult();
}
