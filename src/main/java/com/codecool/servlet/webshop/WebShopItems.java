package com.codecool.servlet.webshop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class WebShopItems {

    private static WebShopItems INSTANCE = null;
    private static List<Item> availableItems = new ArrayList<>();

    private WebShopItems() {
        Item item1 = new Item("Tenkaichi Japanese Green Tea", 1500.0);
        Item item2 = new Item("The Book of Tea", 2000.0);
        Item item3 = new Item("Kyuusu Teapot", 5000.0);
        Item item4 = new Item("Tetsubin Iron Kettle", 15000.0);
        Item item5 = new Item("Chawan Teacup", 3000.0);
        availableItems.addAll(Arrays.asList(item1, item2, item3, item4, item5));
    }
    
    public static WebShopItems getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new WebShopItems();
        }
        return INSTANCE;
    }
    
    public List<Item> getAvailableItems() {
        return availableItems;
    }

    public Item getItemById(int id) {
        return availableItems.stream().
                filter(item -> item.getId() == id).
                findFirst().
                get();
    }
}
