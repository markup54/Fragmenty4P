package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Fragment1 fragment1;
    Fragment2 fragment2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.kontener,fragment1)
                        .commit();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.kontener,fragment2)
                        .commit();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencja = new Intent(MainActivity.this,
                        FragmentActivity.class);
                intencja.putExtra("zmienna","tajne dane");
                startActivity(intencja);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intencja = new Intent();
                intencja.setAction(Intent.ACTION_SEND);
                //dołożenie info
                EditText editText = findViewById(R.id.editTextDoSMS);
                String wiadomosc = editText.getText().toString();
                intencja.putExtra(Intent.EXTRA_TEXT , wiadomosc);
                intencja.setType("text/plain");
                Intent dzielonaIntencja = Intent.createChooser(intencja,null);
                startActivity(dzielonaIntencja);
            }
        });
    }
}