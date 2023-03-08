package com.example.practicatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Unidad1 extends AppCompatActivity {

    TextView tv1, tv2, tv3, tv4;
    CheckBox cb1, cb2, cb3, cb4, cb5, cb6;

    int intentos = 3;
    int puntosTemp = 0;
    int puntos;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unidad1);

        //TextViews
        tv1 = findViewById(R.id.txtPuntosCantidad1);
        tv2 = findViewById(R.id.txtIntentos);
        tv3 = findViewById(R.id.txtGastado);
        tv4 = findViewById(R.id.lblSinIntentos);
        tv4.setVisibility(View.GONE);

        //Checkbox
        cb1 = findViewById(R.id.cbColores);
        cb2 = findViewById(R.id.cbMainAct);
        cb3 = findViewById(R.id.cbLocalProp);
        cb4 = findViewById(R.id.cbActivityMain);
        cb5 = findViewById(R.id.cbManifest);
        cb6 = findViewById(R.id.cbThemes);

    }

    //Intent
    public void switchU2() {
        Intent switchIntent = new Intent(this, Unidad2.class);
        switchIntent.putExtra("ptosTotales", tv1.getText().toString());
        startActivity(switchIntent);
    }

    //Añadir y Restar puntos
    public void check() {
        puntosTemp = 0;
        if (cb1.isChecked()) { puntosTemp ++; }
        if (cb2.isChecked()) { puntosTemp --; }
        if (cb3.isChecked()) { puntosTemp --; }
        if (cb4.isChecked()) { puntosTemp ++; }
        if (cb5.isChecked()) { puntosTemp --; }
        if (cb6.isChecked()) { puntosTemp ++; }
    }

    //Main
    public void siguiente1(View view) {
        if(intentos != 0) {
            check();

            //Cambiar los puntos
            if (puntosTemp > puntos) {
                puntos = puntosTemp;
                tv1.setText(String.valueOf(puntos));
            } else if (puntos <= 0) {
                puntos = 0;
                tv1.setText(String.valueOf(puntos));
            }

            //Labels
            intentos--;
            tv2.setText("Tienes " + String.valueOf(intentos) + " intentos");
            contador++;
            tv3.setText("Has gastado " + String.valueOf(contador) + " intentos");
            if(intentos == 0) {
                tv4.setVisibility(View.VISIBLE);
            }

        } else {
            switchU2(); // Cambiar actividades
        }


    }

}