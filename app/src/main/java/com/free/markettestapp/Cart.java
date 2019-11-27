package com.free.markettestapp;

import java.util.ArrayList;
import java.util.List;

public class Cart {


    public static Cart instance;

    public static Cart getInstance() {

        if (instance == null) {
            instance = new Cart();
        }
        return instance;
    }


    private List<Fruit> items = new ArrayList<>();

    public List<Fruit> getItems() {
        return items;
    }

    public void add(Fruit fruit) {
        items.add(fruit);
    }

}
