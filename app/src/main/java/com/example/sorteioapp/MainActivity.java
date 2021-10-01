package com.example.sorteioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText edMin, edMax;
    TextView tvResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edMin = findViewById(R.id.edMin);
        edMax = findViewById(R.id.edMax);
        tvResultado = findViewById(R.id.tvResultado);
    }

    public void sorteio(View v){

        int min, max;
        min = Integer.parseInt(edMin.getText().toString());
        max = Integer.parseInt(edMax.getText().toString());
            int resultado = new Random().nextInt((max - min))+min;

        tvResultado.setText(Integer.toString(resultado));

    }
}