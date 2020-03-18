package com.company;

public class Food implements Item, Comparable<Item> {
    private String name;
    private double weight;

    public Food(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getValue() {
        return getWeight() * 2;
    }

    public int compareTo(Item item) {
        return this.getName().compareTo(item.getName());
    }

    @Override
    public String toString() {
        return "Food: " + this.getName() + ", weight = " + this.getWeight() + ", value = " + this.getValue() +
                ", profit = " + this.profitFactor();
    }
}
