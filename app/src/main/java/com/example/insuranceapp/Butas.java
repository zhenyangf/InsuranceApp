package com.example.insuranceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Butas extends AppCompatActivity {
    EditText luboMetrai;
    TextView lubosKaina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butas);
    }

    public void lubosSkaiciavimas() {
        luboMetrai = findViewById(R.id.lubosMetrai);
        String metrai = luboMetrai.getText().toString();
        int value = Integer.parseInt(metrai);
        int pirmasAts;
        int antrasAts;
        pirmasAts = value * 45;
        antrasAts = value * 90;
        TextView kaina = (TextView)findViewById(R.id.luboskainas);
        kaina.setText("Kainuos tarp " + pirmasAts + " - " +antrasAts);
    }
    @SuppressLint("SetTextI18n")
    public void calculate(View view){
        lubosSkaiciavimas();

    }




}