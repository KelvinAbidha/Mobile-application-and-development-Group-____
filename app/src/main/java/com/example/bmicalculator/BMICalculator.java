package com.example.bmicalculator;

public class BMICalculator {

    public static double calculateBMI(double weightKg, double heightM) {
        if (heightM <= 0) {
            return 0;
        }
        return weightKg / (heightM * heightM);
    }

    public static String getCategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
