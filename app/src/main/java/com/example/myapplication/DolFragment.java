package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class DolFragment extends Fragment {

    Button button;
    EditText editText;
    FragmentDListener listener;

    public interface  FragmentDListener{
        void onInputDSent (CharSequence input);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_dol,container,false);
        button =view.findViewById(R.id.button6);
        editText = view.findViewById(R.id.editText2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence input =  editText.getText();
                listener.onInputDSent(input);
            }
        });
        return view;
    }
    public void zaktualizujEditText (CharSequence nowyText){
        editText.setText(nowyText);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (FragmentDListener)context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}