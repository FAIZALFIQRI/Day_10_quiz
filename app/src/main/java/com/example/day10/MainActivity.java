package com.example.day10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioGroup rgType;
    RadioButton rbPajero;
    RadioButton rbAlphard;
    RadioButton rbInnova;
    RadioButton rbBrio;
    RadioGroup rgCity;
    RadioButton rbIcity;
    RadioButton rbOcity;
    EditText etTotal;
    Button btnRent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rgType = findViewById(R.id.rgType);
        rbPajero = findViewById(R.id.rbPajero);
        rbAlphard = findViewById(R.id.rbAlphard);
        rbInnova = findViewById(R.id.rbInnova);
        rbBrio = findViewById(R.id.rbBrio);
        rgCity = findViewById(R.id.rgCity);
        rbIcity = findViewById(R.id.rbIcity);
        rbOcity = findViewById(R.id.rbOcity);
        etTotal = findViewById(R.id.etTotal);
        btnRent = findViewById(R.id.btnRent);
        btnRent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processTransaction();
            }
        });
    }

    private void processTransaction() {
        int selectedItemId = rgType.getCheckedRadioButtonId();
        if (selectedItemId == -1) {
            Toast.makeText(this, "Pilih mobil terlebih dahulu", Toast.LENGTH_SHORT).show();
            return;
        }

        RadioButton selectedType = findViewById(selectedItemId);
        String carTpye = selectedType.getText().toString();
        double jumlahMobil;

        try {
            jumlahMobil = Double.parseDouble(etTotal.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Masukkan jumlah yang valid", Toast.LENGTH_SHORT).show();
            return;
        }

        double hargamobil = 0;

        switch (carTpye) {
            case "Pajero":
                hargamobil = 2400000;
                break;
            case "Alphard":
                hargamobil = 1550000;
                break;
            case "Innova":
                hargamobil = 850000;
                break;
            case "Brio":
                hargamobil = 550000;
                break;
        }

        double totalharga = hargamobil * jumlahMobil;
        int selectedId = rgCity.getCheckedRadioButtonId();
        double tambahanBiaya = 0;
        String outsidecity = null;
        if (selectedId != -1) {
            RadioButton radioButton = findViewById(selectedId);
            outsidecity = radioButton.getText().toString();
            switch (outsidecity) {
                case "insidecity":
                    tambahanBiaya = totalharga + 135000;
                    break;
                case "outsidecity":
                    tambahanBiaya = totalharga + 250000;
                    break;
            }
        }
        if (totalharga > 10000000) {
            totalharga -= 0.07;

                double discountHarga = (hargamobil * jumlahMobil) - totalharga;
                double jumlahBayar = totalharga + tambahanBiaya;

                Intent detail = new Intent(this, DetailActivity.class);
                detail.putExtra("Name", carTpye);
                detail.putExtra("Outside city", outsidecity);
                detail.putExtra("Day of Rent", jumlahMobil);
                detail.putExtra("Discount", discountHarga);
                detail.putExtra("total", jumlahBayar);

        }
    }
}
