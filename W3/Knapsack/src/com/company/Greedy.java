package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Greedy implements Algorithm{
    private Knapsack knapsack;

    public Greedy(Knapsack knapsack) {
        this.knapsack = knapsack;
    }

    public Knapsack getKnapsack() {
        return knapsack;
    }

    public void setKnapsack(Knapsack knapsack) {
        this.knapsack = knapsack;
    }

    public List<Item> solve() {
        List<Item> items = knapsack.getItems();
        List<Item> selectedItems = new ArrayList<>();

        items.sort(Comparator.comparing(Item::getValue, Comparator.reverseOrder()));
        System.out.println(items);

        double totalWeight = 0;
        int i = 0;

        for (Item item : items) {
            if (item.getWeight() + totalWeight <= knapsack.getCapacity()) {
                totalWeight += item.getWeight();
                selectedItems.add(item);
            }
        }

        return selectedItems;
    }
}
