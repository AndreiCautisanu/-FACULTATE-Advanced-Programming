package com.company;

public class Book implements Item, Comparable<Item> {
    private String name;
    private int pageNumber;
    private double value;

    public Book(String name, int pageNumber, double value) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getWeight() {
        return (double)getPageNumber() / 100;
    }

    public int compareTo(Item item) {
        return this.getName().compareTo(item.getName());
    }

    @Override
    public String toString() {
        return "Book: " + this.getName() + ", weight = " + this.getWeight() + ", value = " + this.getValue() +
                ", profit = " + this.profitFactor();
    }
}
