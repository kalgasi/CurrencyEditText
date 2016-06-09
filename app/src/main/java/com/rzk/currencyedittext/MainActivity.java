package com.rzk.currencyedittext;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    TextView textViewHasil;
    TextInputEditText editTextAngka;
    AppCompatButton buttonSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewHasil = (TextView) findViewById(R.id.tv_hasil);
        editTextAngka = (TextInputEditText) findViewById(R.id.edt_angka);
        editTextAngka.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!s.toString().equals("")){
                    editTextAngka.removeTextChangedListener(this);
                    String cleanString = s.toString().replaceAll("[$,.]", "");

                    double parsed = Double.parseDouble(cleanString);
                    String formatted = NumberFormat.getCurrencyInstance().format((parsed/100));

                    String current = formatted;
                    editTextAngka.setText(formatted);
                    editTextAngka.setSelection(formatted.length());
                    editTextAngka.addTextChangedListener(this);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        buttonSet=(AppCompatButton) findViewById(R.id.button_set);
        buttonSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editTextAngka.getText().toString().equals("")){
                    textViewHasil.setText(editTextAngka.getText().toString());
                }
            }
        });
    }


}
