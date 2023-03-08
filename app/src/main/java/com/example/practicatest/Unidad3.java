package com.example.practicatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Unidad3 extends AppCompatActivity {

    Spinner spn1, spn2;
    TextView tv1_3;

    int puntos;
    String[] opciones1 = {"fillIn()","setData()","putExtra()","clone()"};
    String[] opciones2 = {"BuildConfig","mipmap","drawable","AndroidManifest"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unidad3);

        //spinners
        spn1 = findViewById(R.id.spnActivity);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones1);
        spn1.setAdapter(adapter1);

        spn2 = findViewById(R.id.spnIcon);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones2);
        spn2.setAdapter(adapter2);

        //spn2
        spn2.setEnabled(false);

        //Puntos totales
        tv1_3 = findViewById(R.id.txtPuntosCantidad3);
        String enviado = getIntent().getStringExtra("ptosTotales2");
        tv1_3.setText(enviado);
        puntos = Integer.parseInt(tv1_3.getText().toString());


    }

    //Intent para el Activity4(Suspenso)
    public void switchSuspendido() {
        Intent switchIntent = new Intent(this, Suspenso.class);
        switchIntent.putExtra("ptosTotales3", tv1_3.getText().toString());
        startActivity(switchIntent);
    }

    //Intent para el Activity5(Aprobado)
    public void switchAprobado() {
        Intent switchIntent = new Intent(this, Aprobado.class);
        switchIntent.putExtra("ptosTotales3", tv1_3.getText().toString());
        startActivity(switchIntent);
    }

    //Chequear los puntos del Spinner1
    public void check3_1() {
        if(spn1.getSelectedItem() == "putExtra()") {
            puntos += 2;
        } else {
            puntos -= 1;
        }
    }

    //Habilitar el Spinner2 y actualizar los puntos
    public void siguiente3(View view) {
        check3_1();
        if(puntos > 0) {
            tv1_3.setText(String.valueOf(puntos));
        } else {
            puntos = 0;
            tv1_3.setText(String.valueOf(puntos));
        }
        spn2.setEnabled(true);
        spn1.setEnabled(false);
    }

    //Chequear los puntos del Spinner2
    public void check3_2() {
        if(spn2.getSelectedItem() == "mipmap") {
            puntos += 2;
        } else {
            puntos -= 1;
        }
    }

    //Switch Activity
    public void calificar(View view) {
        check3_2();
        if(puntos >= 5) {
            tv1_3.setText(String.valueOf(puntos));
            switchAprobado();
        } else {
            tv1_3.setText(String.valueOf(puntos));
            switchSuspendido();
        }
    }

}