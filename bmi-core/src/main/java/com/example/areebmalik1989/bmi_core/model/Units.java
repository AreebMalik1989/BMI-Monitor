package com.example.areebmalik1989.bmi_core.model;

public class Units {

    public enum WeightUnit {

        KG("Kilogram"),
        POUND("Pound"),
        STONE_POUND("Stone-Pound"),
        UNKNOWN("Unknown");

        private String weightUnit;

        WeightUnit(String weightUnit){
            this.weightUnit = weightUnit;
        }

        @Override
        public String toString() {
            return weightUnit;
        }
    }

    public enum LengthUnit {

        METER("Meter"),
        CENTIMETER("Centimeter"),
        FOOT_INCH("Foot-Inch"),
        INCH("Inch"),
        UNKNOWN("Unknown");

        private String lengthUnit;

        LengthUnit(String lengthUnit){
            this.lengthUnit = lengthUnit;
        }

        @Override
        public String toString() {
            return lengthUnit;
        }
    }
}
