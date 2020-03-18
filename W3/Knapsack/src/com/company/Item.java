package com.company;

public interface Item {
    double getWeight();
    String getName();
    double getValue();

    default double profitFactor() {
        return getValue() / getWeight();
    }

}
