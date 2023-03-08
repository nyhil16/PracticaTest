package com.example.practicatest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Aprobado extends AppCompatActivity {

    TextView tv1_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aprobado);

        tv1_5 = findViewById(R.id.txtPuntuacionAprob);
        String enviado = getIntent().getStringExtra("ptosTotales3");
        tv1_5.setText("Puntuacion: "+enviado);
    }

    public void cerrar(View view) {
        finishAffinity();
        System.exit(0);
    }
}