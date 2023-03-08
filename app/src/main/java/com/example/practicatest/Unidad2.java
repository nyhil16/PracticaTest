package com.example.practicatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Unidad2 extends AppCompatActivity {

    RadioGroup rg1;
    TextView tv1_2;
    int puntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unidad2);

        //RadioGroup
        rg1 = findViewById(R.id.radioGroup);

        //Puntos totales
        tv1_2 = findViewById(R.id.txtPuntosCantidad2);
        String enviado = getIntent().getStringExtra("ptosTotales");
        tv1_2.setText(enviado);
        puntos = Integer.parseInt(tv1_2.getText().toString());

    }

    //Intent
    public void switchU3() {
        Intent switchIntent = new Intent(this, Unidad3.class);
        switchIntent.putExtra("ptosTotales2", tv1_2.getText().toString());
        startActivity(switchIntent);
    }

    //Añadir o restar puntos
    public void check2() {
        switch (rg1.getCheckedRadioButtonId()) {
            case R.id.rbInt:
                puntos += 3;
                break;
            case R.id.rbBoolean:
            case R.id.rbChar:
            case R.id.rbDouble:
            case R.id.rbString:
                puntos -= 2;
                break;
        }
    }

    //Main
    public void siguiente2(View view) {
        check2();

        //Actualizar puntos
        if(puntos > 0) {
            tv1_2.setText(String.valueOf(puntos));
        } else {
            puntos = 0;
            tv1_2.setText(String.valueOf(puntos));
        }

        //Cambiar Activity
        switchU3();
    }


}