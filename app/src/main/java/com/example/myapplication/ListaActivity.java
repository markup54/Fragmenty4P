package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ListaActivity extends AppCompatActivity {
ListaFragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        fragment = new ListaFragment();
       /* getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.kontenerlista,fragment)
                .commit();

        */
    }
}