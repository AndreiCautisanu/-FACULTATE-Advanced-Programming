package com.company;

import java.util.List;

public class Dynamic {
    private Knapsack knapsack;

    public Dynamic(Knapsack knapsack) {
        this.knapsack = knapsack;
    }

    public Knapsack getKnapsack() {
        return knapsack;
    }

    public void setKnapsack(Knapsack knapsack) {
        this.knapsack = knapsack;
    }

    public void solve() {
        int size = knapsack.getItems().size();
        int capacity = (int)knapsack.getCapacity();
        List<Item> items = knapsack.getItems();

        int selected[][] = new int[size+1][capacity+1];

        for (int i = 0; i <= size; i++) {
            for (int w = 0; w < capacity; w++) {
                if (i == 0 || w == 0) {
                    selected[i][w] = 0;
                }
                else if (items.get(i-1).getWeight() <= w) {
                    selected[i][w] = Math.max(selected[i-1][w],
                            selected[i-1][w - (int)items.get(i-1).getWeight()] + (int)items.get(i-1).getValue());
                }
                else {
                    selected[i][w] = selected[i-1][w];
                }
            }
        }

        for (int i = 0; i < size+1; i++) {
            for (int j = 0; j < capacity+1; j++) {
                System.out.print(selected[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
}
