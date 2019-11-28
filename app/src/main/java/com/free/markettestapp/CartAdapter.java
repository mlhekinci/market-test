package com.free.markettestapp;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;

public class CartAdapter extends ArrayAdapter {



    private int resourceId;
    private DatePickerDialog datePickerDialog;

    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;

    public CartAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
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


        Button btnOther = view.findViewById(R.id.cancel);
        Button payButton = view.findViewById(R.id.buy);


        btnOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(view.getContext(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                Toast.makeText(getContext(), day + "/" + (month + 1) + "/" + year + " Tarihinde  gel dalından kopar ya da bahçeden topla", Toast.LENGTH_LONG).show();
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              Intent i = new Intent(getContext(), PayActivity.class);
              getContext().startActivity(i);
            }
        });



        fruitImage.setImageResource(fruit.getImageId());
        fruitName.setText(fruit.getName());
        fruitIntroduction.setText(fruit.getIntroduction());
        return view;

    }

}
