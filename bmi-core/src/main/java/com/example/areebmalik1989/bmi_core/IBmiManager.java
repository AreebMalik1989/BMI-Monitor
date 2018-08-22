package com.example.areebmalik1989.bmi_core;

public interface IBmiManager {

    /**
     * Collects data to calculate bmi
     *
     * @param weight : weight value
     * @param weightType : weight unit
     * @param height : height value
     * @param heightType : height unit
     */
    void collectBmiData(double weight, String weightType, double height, String heightType);

    /**
     * Returns bmi
     *
     * @return : returns bmi
     */
    double giveBmi();

    /**
     * Returns bmi translation
     *
     * @return : returns bmi translation
     */
    String giveBmiTranslation();
}
