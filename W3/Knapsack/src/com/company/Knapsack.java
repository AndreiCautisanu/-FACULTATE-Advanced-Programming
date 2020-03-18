package com.company;

import sun.plugin.javascript.navig.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Knapsack {
    private double capacity;
    private List<Item> items = new ArrayList<>();

    public Knapsack(double capacity, List<Item> items) {
        this.capacity = capacity;
        this.items = items;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public String toString() {
        items.sort(Comparator.comparing(Item::getName));

        StringBuilder toPrint = new StringBuilder();
        toPrint.append("Capacity = " + this.getCapacity() + "\nAvailable Items: \n");

        /*for (Item item : items) {
            toPrint.append(item.getClass().toString().replace("class com.company.", "") + ": " + item.getName()
            + ", weight = " + item.getWeight() + ", value = " + item.getValue()
            + ", PROFIT FACTOR = " + item.profitFactor() + "\n");
        }*/

        for (Item item : items) {
            toPrint.append(item.toString());
            toPrint.append("\n");
        }

        return toPrint.toString();

    }
}
