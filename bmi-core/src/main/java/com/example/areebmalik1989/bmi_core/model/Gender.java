package com.example.areebmalik1989.bmi_core.model;

public enum Gender {

    MALE("Male"),
    FEMALE("Female");

    private String gender;

    Gender(String gender){
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender;
    }
}
