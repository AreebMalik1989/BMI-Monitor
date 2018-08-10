package com.example.areebmalik1989.bmimonitor.model;

public class Person {

    /**
     * Weight in kilogram
     */
    private double weight;

    /**
     * Height in meter
     */
    private double height;

    /**
     * Age in years
     */
    private int age;

    /**
     * Gender M/F
     */
    private Gender gender;

    public Person(){}

    public Person(double weight, double height, int age, Gender gender) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
