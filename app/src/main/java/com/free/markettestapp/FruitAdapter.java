package com.free.markettestapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter {

    private int resourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Fruit fruit = (Fruit) getItem(position);
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        } else {
            view = convertView;
        }
        ImageView fruitImage = (ImageView) view.findViewById(R.id.thumbnail);
        TextView fruitName = (TextView) view.findViewById(R.id.title);
        TextView fruitIntroduction = (TextView) view.findViewById(R.id.kg);

        Button button = view.findViewById(R.id.add_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cart.getInstance().add(fruit);
                Log.d("Size", String.valueOf(Cart.getInstance().getItems().size()));
            }
        });

        fruitImage.setImageResource(fruit.getImageId());
        fruitName.setText(fruit.getName());
        fruitIntroduction.setText(fruit.getIntroduction());
        return view;

    }

}
