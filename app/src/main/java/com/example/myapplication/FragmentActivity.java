package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        String przekazanaZmienna = getIntent().getStringExtra("zmienna");
        Toast.makeText(FragmentActivity.this,
                przekazanaZmienna, Toast.LENGTH_SHORT).show();
        DolFragment dolFragment = new DolFragment();
        GornyFragment gornyFragment = new GornyFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.gora,gornyFragment)
                .replace(R.id.dol,dolFragment)
                .commit();
    }
}