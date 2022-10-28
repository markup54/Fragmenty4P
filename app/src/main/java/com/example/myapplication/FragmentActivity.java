package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FragmentActivity extends AppCompatActivity implements DolFragment.FragmentDListener, GornyFragment.FragmentGListener {
    DolFragment dolFragment;
    GornyFragment gornyFragment;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        String przekazanaZmienna = getIntent().getStringExtra("zmienna");
        Toast.makeText(FragmentActivity.this,
                przekazanaZmienna, Toast.LENGTH_SHORT).show();
        dolFragment = new DolFragment();
        gornyFragment = new GornyFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.gora,gornyFragment)
                .replace(R.id.dol,dolFragment)
                .commit();
        button = findViewById(R.id.button7);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intencja = new Intent(FragmentActivity.this,
                                ListaActivity.class);
                        startActivity(intencja);
                    }
                }
        );
    }

    @Override
    public void onInputDSent(CharSequence input) {
        gornyFragment.zaktualizujEditText(input);
    }

    @Override
    public void onInputGSent(CharSequence input) {
        dolFragment.zaktualizujEditText(input);
    }
}