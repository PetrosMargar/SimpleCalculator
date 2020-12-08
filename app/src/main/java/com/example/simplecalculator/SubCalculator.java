package com.example.simplecalculator;

public class SubCalculator implements Calculation {
    @Override
    public int calculate(int a, int b) {
        return a - b;
    }
}
