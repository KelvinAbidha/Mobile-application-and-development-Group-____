package com.example.bmicalculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class BMICalculatorTest {

    @Test
    public void calculateBMI_isCorrect() {
        double weight = 70;
        double height = 1.75;
        double expected = 70 / (1.75 * 1.75);
        assertEquals(expected, BMICalculator.calculateBMI(weight, height), 0.01);
    }

    @Test
    public void getCategory_Underweight() {
        assertEquals("Underweight", BMICalculator.getCategory(18.4));
    }

    @Test
    public void getCategory_Normal() {
        assertEquals("Normal", BMICalculator.getCategory(22.0));
    }

    @Test
    public void getCategory_Overweight() {
        assertEquals("Overweight", BMICalculator.getCategory(27.0));
    }

    @Test
    public void getCategory_Obese() {
        assertEquals("Obese", BMICalculator.getCategory(31.0));
    }
}
