package com.example.insuranceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Butas extends AppCompatActivity {
    EditText luboMetrai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butas);
    }

    public void lubosSkaiciavimas(){
        luboMetrai = findViewById(R.id.lubosMetrai);
        String metrai = luboMetrai.getText().toString();
        int value = Integer.parseInt(metrai);
        int pirmasAts;
        int antrasAts;
        pirmasAts = value*45;
        antrasAts = value*90;

    }


}