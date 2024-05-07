package com.example.day10;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tvCarType, tvOutsideCity, tvDayOfRent, tvDiscount, tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvCarType = findViewById(R.id.tvCarType);
        tvOutsideCity = findViewById(R.id.tvOutsideCity);
        tvDayOfRent = findViewById(R.id.tvDayOfRent);
        tvDiscount = findViewById(R.id.tvDiscount);
        tvTotal = findViewById(R.id.tvTotal);

        Intent intent = getIntent();
        String carType = intent.getStringExtra("Name");
        String outsideCity = intent.getStringExtra("Outside city");
        double dayOfRent = intent.getDoubleExtra("Day of Rent", 0);
        double discount = intent.getDoubleExtra("Discount", 0);
        double total = intent.getDoubleExtra("total", 0);

        tvCarType.setText("Car Type: " + carType);
        tvOutsideCity.setText("Outside City: " + outsideCity);
        tvDayOfRent.setText("Day of Rent: " + dayOfRent);
        tvDiscount.setText("Discount: " + discount);
        tvTotal.setText("Total: " + total);
    }
}