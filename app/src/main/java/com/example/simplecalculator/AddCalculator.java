package com.example.simplecalculator;

public class AddCalculator implements Calculation {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
}
