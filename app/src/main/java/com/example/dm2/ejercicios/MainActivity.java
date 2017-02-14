package com.example.dm2.ejercicios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void ejercicio1 (View v) {
        Intent intent = new Intent(MainActivity.this,ejercicio1_ficheros.class);
        startActivity(intent);
    }
    public void ejercicio2 (View v) {
        Intent intent = new Intent(MainActivity.this,ejercicio2_ficheros.class);
        startActivity(intent);
    }
    public void ejercicio3 (View v) {
        Intent intent = new Intent(MainActivity.this,ejercicio3_ficheros.class);
        startActivity(intent);
    }
    public void salir (View v)
    {
        finish();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
