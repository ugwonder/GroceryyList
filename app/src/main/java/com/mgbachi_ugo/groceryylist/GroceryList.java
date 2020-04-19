package com.mgbachi_ugo.groceryylist;

import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;

class GroceryList implements Serializable {
    private String grocery, price;

    GroceryList(String grocery, String price) {
        this.grocery = grocery;
        this.price = price;
    }

    String getGrocery() {
        return grocery;
    }

    String getPrice() {
        return price;
    }
}
