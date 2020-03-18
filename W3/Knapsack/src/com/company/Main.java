package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Book book1 = new Book("Dragon Rising", 300, 5);
        Book book2 = new Book("A Blade in the Dark", 300, 5);
        Food food1 = new Food("Cabbage", 2);
        Food food2 = new Food("Rabbit", 2);
        Weapon weapon1 = new Weapon(WeaponType.SWORD, 5, 10);

        System.out.println(book1.getWeight());

        List<Item> items = new ArrayList<>();
        items.add(book1);
        items.add(book2);
        items.add(food1);
        items.add(food2);
        items.add(weapon1);

        Knapsack knap = new Knapsack(10, items);
        System.out.println(knap.toString());

        Greedy greedy1 = new Greedy(knap);
        List<Item> greedySolved = greedy1.solve();
        System.out.println("Items selected Greedy: " + greedySolved.toString());

        double totalWeight = 0, totalValue = 0;
        for (Item item : greedySolved) {
            totalWeight += item.getWeight();
            totalValue += item.getValue();
        }
        System.out.println("Total Weight = " + totalWeight + "\nTotal Value = " + totalValue + "\n\n");


        Dynamic dynamic1 = new Dynamic(knap);
        dynamic1.solve();


    }
}
