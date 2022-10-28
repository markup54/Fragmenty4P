package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class GornyFragment extends Fragment {
    Button button;
    EditText editText;
    FragmentGListener listener;

    public interface  FragmentGListener{
        void onInputGSent (CharSequence input);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater
                .inflate(R.layout.fragment_gorny, container, false);
        button = view.findViewById(R.id.button5);
        editText = view.findViewById(R.id.editText1);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String pobranyTekst = editText.getText().toString();
                        CharSequence input = editText.getText();
                        listener.onInputGSent(input);
                    }
                }
        );
        return view;
    }
}