package com.example.user.bmicalc;

/**
 * Created by User on 2/10/2018.
 */

public class BMIResult {
    private double height = 1;
    private double weight = 1;
    private double bmi = 1;
    private String date_value = "";

    public BMIResult(double height, double weight , double bmi, String date) {
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.date_value = date;
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {this.height = height ;}

    public double getWeight(){
        return weight;
    }
    public void setWeight(double weight){this.height = weight;}

    public String getDate(){
        return date_value;
    }
    public void setDate_value(String date_value){this.date_value = date_value;}

    public double getResult(){
        return  height/(weight*weight);
    }

    public String toString() {return String.valueOf(getResult());}
}