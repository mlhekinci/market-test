package com.free.markettestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        CartAdapter cartAdapter = new CartAdapter(CartActivity.this, R.layout.cart_item, Cart.getInstance().getItems());

        ListView listView = findViewById(R.id.list);
        listView.setAdapter(cartAdapter);
    }
}
