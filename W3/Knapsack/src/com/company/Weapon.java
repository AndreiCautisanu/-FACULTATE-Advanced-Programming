package com.company;

public class Weapon implements Item, Comparable<Item> {
    private WeaponType type;
    private double weight;
    private double value;

    public Weapon(WeaponType type, double weight, double value) {
        this.type = type;
        this.weight = weight;
        this.value = value;
    }

    public String getName() {
        return type.name();
    }

    public void setType(WeaponType type) {
        this.type = type;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public int compareTo(Item item) {
        return this.getName().compareTo(item.getName());
    }

    @Override
    public String toString() {
        return "Weapon: " + this.getName() + ", weight = " + this.getWeight() + ", value = " + this.getValue() +
                ", profit = " + this.profitFactor();
    }
}
