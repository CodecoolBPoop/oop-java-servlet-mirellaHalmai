package com.codecool.servlet.webshop;

public class Item {

    private int id;
    private static int nextId = 0;
    private String name;
    private double price;

    public Item(String name, double price) {
        id = nextId++;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }
}
