package com.free.markettestapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    private List<Fruit> fruitList = new ArrayList<Fruit>();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruits();
        listView = findViewById(R.id.listView);
        FruitAdapter fruitAdapter = new FruitAdapter(MainActivity.this, R.layout.item, fruitList);
        listView.setAdapter(fruitAdapter);

        FloatingActionButton floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, CartActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });


    }




    private void initFruits() {

        Fruit apple = new Fruit("Elma", R.drawable.apples,"30 Kg");
        Fruit kiwi = new Fruit("Kivi", R.drawable.kiwi, "30 Kg");
        Fruit strawberry = new Fruit("Çilek", R.drawable.strawberry, "30 Kg");
        Fruit watermelon = new Fruit("Karpuz", R.drawable.watermelon, "30 Kg");
        Fruit grapes = new Fruit("Üzüm", R.drawable.grapes, "30 Kg");
        Fruit pineapple = new Fruit("Ananas", R.drawable.downloadfruit, "30 Kg");
        Fruit banana = new Fruit("Muz", R.drawable.download, "30 Kg");
        Fruit orange = new Fruit("Portakal", R.drawable.orange, "30 Kg");
        Fruit peach = new Fruit("Şeftali", R.drawable.s, "30kg");
        Fruit grapefruit = new Fruit("Greyfurt", R.drawable.grey, "30kg");

        fruitList.add(watermelon);
        fruitList.add(strawberry);
        fruitList.add(kiwi);
        fruitList.add(apple);
        fruitList.add(grapes);
        fruitList.add(pineapple);
        fruitList.add(banana);
        fruitList.add(orange);
        fruitList.add(peach);
        fruitList.add(grapefruit);

    }

}
