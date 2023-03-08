package com.example.practicatest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Suspenso extends AppCompatActivity {

    TextView tv1_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.suspenso);

        tv1_4 = findViewById(R.id.txtPuntuacionSusp);
        String enviado = getIntent().getStringExtra("ptosTotales3");
        tv1_4.setText("Puntuacion: "+enviado);
    }

    public void cerrar(View view) {
        finishAffinity();
        System.exit(0);
    }
}